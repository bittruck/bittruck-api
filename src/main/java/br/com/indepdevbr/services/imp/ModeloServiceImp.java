package br.com.indepdevbr.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Modelo;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IModeloService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.MarcaRepository;
import br.com.indepdevbr.services.repository.ModeloRepository;

@Service
public class ModeloServiceImp extends SuperClasse<ModeloRepository> implements IModeloService {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Override
	public Modelo buscarPorIdEIdMarca(Long id, Long idMarca) {
		try {
			return repository.findByIdAndMarcaId(id, idMarca)
					.map( modelo -> {
						return modelo;
					})
					.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum modelo encontrado pelo id: " + id + " e marca_id:" + idMarca));			
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public Page<Modelo> listarPaginadoPorIdMarca(Long idMarca, Pageable pageable) {
		try {
			return repository.findByMarcaId(idMarca, pageable)
					.map( modelos -> {
						return modelos;
					});
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}
	
	@Override
	public List<Modelo> listarTodosPorIdMarca(Long idMarca) {
		try {
			return repository.findByMarcaId(idMarca)
								.stream()
								.map( modelos -> {
									return modelos;
								})
								.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

	@Override
	public Modelo inserir(Long idMarca, Modelo modelo) {
		try {
			return marcaRepository.findById(idMarca)
					.map( marca -> {
						modelo.setMarca(marca);
						return repository.save(modelo);
					})
					.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma marca encontrada pelo id:" + idMarca));
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public Modelo atualizar(Long idMarca, Modelo modelo) {
		try {
			if(!repository.existsByIdAndMarcaId(modelo.getId(), idMarca)) {
				throw new RecursoNaoEncontradoException("Nenhum modelo encontrado pelo id: " + modelo.getId() + " e marca_id: " + idMarca);
			}
			return repository.save(modelo);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public List<Modelo> buscarPorIdMarcaENomModeloContem(Long marcaId, String nomModelo) {
		try {
			List<Modelo> modelos = repository.findByMarcaIdAndNomModeloContaining(marcaId, nomModelo);
			return modelos;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

}
