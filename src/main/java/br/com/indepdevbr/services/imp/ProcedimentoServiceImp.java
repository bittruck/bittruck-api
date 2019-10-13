package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.IProcedimentoService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.ProcedimentoRepository;

@Service
public class ProcedimentoServiceImp extends SuperClasse<ProcedimentoRepository> implements IProcedimentoService {

}
