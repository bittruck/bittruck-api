package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.IMarcaService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.MarcaRepository;

@Service
public class MarcaServiceImp extends SuperClasse<MarcaRepository> implements IMarcaService {

}
