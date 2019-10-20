package br.com.indepdevbr.services.imp;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Procedimento;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IProcedimentoService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.ProcedimentoRepository;

@Service
public class ProcedimentoServiceImp extends SuperClasse<ProcedimentoRepository> implements IProcedimentoService {

	@Override
	@Cacheable("procecimentos")
	public Procedimento buscarPorId(Long id) {
		try {
			return repository.findById(id)
					.map( p -> {
						return p;
					})
					.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum procedimento encontrado pelo id: " + id));
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	@Cacheable("procecimentos")
	public List<Procedimento> listarTodos() {
		try {
			List<Procedimento> procedimentos = repository.findAll();
			return procedimentos;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

}
