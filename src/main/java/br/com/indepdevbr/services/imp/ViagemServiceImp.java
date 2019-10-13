package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.IViagemService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.ViagemRepository;

@Service
public class ViagemServiceImp extends SuperClasse<ViagemRepository> implements IViagemService {

}
