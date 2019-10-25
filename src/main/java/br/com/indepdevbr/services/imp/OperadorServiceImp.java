package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.exception.BittruckException;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IOperadorService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.OperadorRepository;
import br.com.indepdevbr.services.repository.TransportadoraRepository;

@Service
public class OperadorServiceImp extends SuperClasse<OperadorRepository> implements IOperadorService {

	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@Override
	public Operador buscarPorCodLogin(String desEmail) {
		try {
			Operador operador = repository.findByDesEmail(desEmail)
					.map( o -> {
						return o;
					}).orElseThrow(() -> new RecursoNaoEncontradoException("Combinação de usuário e senha inválida"));
			return operador;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new BittruckException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public Operador cadastrarPrimeiroOperador(Transportadora transportadora, Operador operador) {
		try {
			Usuario usuario = usuarioServiceImp.inserir(operador.getUsuario());
			operador.setUsuario(usuario);
			operador.setTransportadora(transportadora);
			return repository.save(operador);
		} catch (Exception e) {
			throw new BittruckException("Ocorreu um problema ao processar a requisição", e);
		}
	}

	@Override
	public Operador inserir(Long idTransportadora, Operador operador) {
		try {
			Usuario usuario = usuarioServiceImp.inserir(operador.getUsuario());
			Operador operadorPersit = transportadoraRepository.findById(idTransportadora)
											.map( transportadora -> {
												operador.setTransportadora(transportadora);
												operador.setUsuario(usuario);
												return repository.save(operador);
											})
											.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma transportadora encontrada pelo id: " + idTransportadora));
			return operadorPersit;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processara a requisição", e);
			}
		}
	}
	
	@Override
	public Operador buscarPorIdEIdTransportadora(Long id, Long transportadoraId) {
		try {
			return repository.findByIdAndTransportadoraId(id, transportadoraId)
					.map( operador -> {
						return operador;
					})
					.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum operador encontrado pelo id: " + id + " transportadora_id: " + transportadoraId));
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um problema ao processar requisição", e);
			}
		}
	}

	@Override
	public Page<Operador> listaPorIdTransportadoraPaginado(Long transportadoraId, Pageable pageable) {
		try {
			Page<Operador> operadores = repository.findByTransportadoraId(transportadoraId, pageable);
			return operadores;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um problema ao processar a requisição", e);
		}
	}
	
	@Override
	public Operador atualizar(Long idTransportadora, Operador operador) {
		try {
			if(!repository.existsByIdAndTransportadoraId(operador.getId(), idTransportadora)) {
				throw new RecursoNaoEncontradoException("Nenhuma operador encontrado pelo id: " + operador.getId() + " e transportadora_id: " + idTransportadora);
			}
			Operador operadorPersist = repository.save(operador);
			return operadorPersist;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processara a requisição", e);
			}
		}
	}
}
