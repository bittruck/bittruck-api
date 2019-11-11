package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Veiculo;
import br.com.indepdevbr.services.imp.VeiculoServiceImp;

@RestController
public class VeiculoController {
	
	@Autowired
	private VeiculoServiceImp veiculoServiceImp;
	
	@PostMapping(value = "/motorista/{idMotorista}/veiculo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Secured({"MOTORISTA"})
	public Veiculo inserir(
			@PathVariable("idMotorista") Long idMotorista,
			@Valid @RequestBody Veiculo veiculo
			) {		
		return veiculoServiceImp.inserir(idMotorista, veiculo);
	}
	
	
}
