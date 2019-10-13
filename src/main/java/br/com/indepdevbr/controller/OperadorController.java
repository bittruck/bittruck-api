package br.com.indepdevbr.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Operador;

@RestController
@RequestMapping("/transportadora/{idTransportadora}/operador") 
public class OperadorController {
	
	@GetMapping("/{idOperador}")
	@Secured({"OPERADOR_ADMIN, OPERADOR"})
	public Operador buscarPorId(
			@PathVariable("idTransportadora") Long idTransportadora,
			@PathVariable("idOperador") Long idOperador
			) {
		System.out.println("");
		return null;
	}
	
}
