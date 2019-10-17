package br.com.indepdevbr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.indepdevbr.models.Procedimento;
import br.com.indepdevbr.services.imp.ProcedimentoServiceImp;

@RestController
@RequestMapping("/procedimento")
public class ProcedimentoController {
	
	@Autowired
	private ProcedimentoServiceImp procedimentoServiceImp;
	
	public Procedimento buscarPorId(@PathVariable("idProcedimento") Long idProcedimento) {
		return procedimentoServiceImp.buscarPorId(idProcedimento);
	}
	
	
	public List<Procedimento> listaTodos() {
		return procedimentoServiceImp.listarTodos();
	}
	
}
