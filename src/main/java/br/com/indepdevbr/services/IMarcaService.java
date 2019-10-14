package br.com.indepdevbr.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.indepdevbr.models.Marca;

public interface IMarcaService {
	
	public Marca buscarPorId(Long id);
	
	public Page<Marca> listarPaginado(Pageable pageable);
	
	public Marca inserir(Marca marca);
	
	public Marca atualizar(Marca marca);
	
}
