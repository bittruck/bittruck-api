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

import br.com.indepdevbr.models.Marca;
import br.com.indepdevbr.services.imp.MarcaServiceImp;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	
	@Autowired
	private MarcaServiceImp marcaServiceImp;
	
	@GetMapping("/{idMarca}")
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Marca buscarPorId(@PathVariable("idMarca") Long idMarca) {
		return marcaServiceImp.buscarPorId(idMarca);
	}
	
	@GetMapping
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Page<Marca> listarPaginado(Pageable pageable) {
		return marcaServiceImp.listarPaginado(pageable);
	}
	
	@PostMapping
	@Secured({"ADMIN"})
	public Marca inserir(@Valid @RequestBody Marca marca) {
		return marcaServiceImp.inserir(marca);
	}
	
	@PutMapping
	@Secured({"ADMIN"})
	public Marca atualizar(@Valid @RequestBody Marca marca) {
		return marcaServiceImp.atualizar(marca);
	}
	
}
