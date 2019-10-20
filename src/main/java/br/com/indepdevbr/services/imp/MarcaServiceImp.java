package br.com.indepdevbr.services.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Marca;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IMarcaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.MarcaRepository;

@Service
public class MarcaServiceImp extends SuperClasse<MarcaRepository> implements IMarcaService {

	@Override
	@Cacheable("marcas")
	public Marca buscarPorId(Long id) {
		try {
			return repository.findById(id)
					.map( marca -> {
						return marca;
					}).orElseThrow(() -> new RecursoNaoEncontradoException("Nenhuma marca encontrada pelo id: " + id));
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	@Cacheable("marcas")
	public Page<Marca> listarPaginado(Pageable pageable) {
		try {
			return repository.findAll(pageable)
					.map( page -> {
						return page;
					});
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}
	
	@Override
	@Cacheable("marcas")
	public List<Marca> listarTodos() {
		try {
			return repository.findAll()
					.stream()
					.map( marcas -> {
						return marcas;
					})
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

	@Override
	public Marca inserir(Marca marca) {
		try {
			return Optional.of(repository.save(marca))
					.map( m -> {
						return m;
					}).orElseThrow(() -> new ErroInternoException("Ocorreu um erro ao processar a requisição"));
					
		} catch (Exception e) {
			if(e instanceof ErroInternoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public Marca atualizar(Marca marca) {
		try {
			if(!repository.existsById(marca.getId())) {
				throw new RecursoNaoEncontradoException("Nenhuma marca encontrada pelo id: " + marca.getId());
			}
			return Optional.of(repository.save(marca))
					.map( m -> {
						return m;
					}).orElseThrow(() -> new ErroInternoException("Ocorreu um erro ao processar a requisição"));
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else if(e instanceof ErroInternoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	@Cacheable("marcas")
	public List<Marca> buscarPorNomMarcaComecaCom(String nomMarca) {
		try {
			List<Marca> marcas = repository.findByNomMarcaStartsWith(nomMarca);
			return marcas;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

}
