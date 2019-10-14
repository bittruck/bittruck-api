package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Operador;
import br.com.indepdevbr.models.Transportadora;
import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.exception.BittruckException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IOperadorService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.OperadorRepository;

@Service
public class OperadorServiceImp extends SuperClasse<OperadorRepository> implements IOperadorService {

	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
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
	public Operador cadastrar(Transportadora transportadora, Operador operador) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
