package br.com.indepdevbr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.services.imp.MotoristaServiceImp;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	
	@GetMapping("/{idMotorista}")
	@Secured({"MOTORISTA, OPERADOR, OPERADOR_ADMIN"})
	public Motorista buscarPorId(@PathVariable("idMotorista") Long idMotorista) {
		return motoristaServiceImp.buscarPorId(idMotorista);
	}
	
}
