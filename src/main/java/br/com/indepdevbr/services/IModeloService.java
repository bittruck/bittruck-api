package br.com.indepdevbr.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.indepdevbr.models.Modelo;

public interface IModeloService {
	
	public Modelo buscarPorIdEIdMarca(Long id, Long idMarca);
	
	public Page<Modelo> listarPaginadoPorIdMarca(Long idMarca, Pageable pageable);
	
	public Modelo inserir(Long idMarca, Modelo modelo);
	
	public Modelo atualizar(Long idMarca, Modelo modelo);
	
	
}
