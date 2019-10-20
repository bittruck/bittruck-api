package br.com.indepdevbr.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.indepdevbr.models.Modelo;

public interface IModeloService {
	
	public Modelo buscarPorIdEIdMarca(Long id, Long idMarca);
	
	public Page<Modelo> listarPaginadoPorIdMarca(Long idMarca, Pageable pageable);
	
	public List<Modelo> listarTodosPorIdMarca(Long idMarca);
	
	public List<Modelo> buscarPorIdMarcaENomModeloComecaCom(Long marcaId, String nomModelo);
	
	public Modelo inserir(Long idMarca, Modelo modelo);
	
	public Modelo atualizar(Long idMarca, Modelo modelo);
	
	
}
