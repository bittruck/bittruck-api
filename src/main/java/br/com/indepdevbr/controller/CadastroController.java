package br.com.indepdevbr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.dto.TransportadoraOperador;
import br.com.indepdevbr.services.imp.MotoristaServiceImp;
import br.com.indepdevbr.services.imp.TransportadoraServiceImp;

@RequestMapping("/cadastro")
@RestController
public class CadastroController {
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	
	@Autowired
	private TransportadoraServiceImp transportadoraServiceImp;
	
	@PostMapping("/motorista")
	public ResponseEntity<?> cadastrarMotorista(@Valid @RequestBody Motorista motorista) {
		motoristaServiceImp.inserir(motorista);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/transportadora_operador")
	public ResponseEntity<?> cadastrarTransportadoraOperador(@Valid @RequestBody TransportadoraOperador transportadoraOperador) {
		transportadoraServiceImp.cadastrarTransportadoraOperador(transportadoraOperador);
		return ResponseEntity.ok().build();
	}
}
