package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.ICargaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.CargaRepository;

@Service
public class CargaServiceImp extends SuperClasse<CargaRepository> implements ICargaService {

}
