package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Modelo;
import br.com.indepdevbr.services.imp.ModeloServiceImp;

@RestController
@RequestMapping("/marca/{idMarca}/modelo")
public class ModeloController {
	
	@Autowired
	private ModeloServiceImp modeloServiceImp;
	
	
	@GetMapping("/{idModelo}")
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Modelo buscarPorIdEIdMarca(
			@PathVariable("idMarca") Long idMarca,
			@PathVariable("idModelo") Long idModelo) {
		return modeloServiceImp.buscarPorIdEIdMarca(idModelo, idMarca);				
	}
	
	@GetMapping
	@Secured({"MOTORISTA","OPERADOR","OPERADOR_ADMIN"})
	public Page<Modelo> listarPaginadoPorIdMarca(@PathVariable("idMarca") Long idMarca,
			Pageable pageable) {
		return modeloServiceImp.listarPaginadoPorIdMarca(idMarca, pageable);
	}
	
	@PostMapping
	@Secured({"ADMIN"})
	public Modelo inserir(@PathVariable("idMarca") Long idMarca,
						  @Valid @RequestBody Modelo modelo) {
		return modeloServiceImp.inserir(idMarca, modelo);
	}
	@PutMapping
	@Secured({"ADMIN"})
	public Modelo atualizar(@PathVariable("idMarca") Long idMarca,
						  @Valid @RequestBody Modelo modelo) {
		return modeloServiceImp.atualizar(idMarca, modelo);
	}
	
}
