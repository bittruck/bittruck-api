package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.IVeiculoService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.VeiculoRepository;

@Service
public class VeiuloServiceImp extends SuperClasse<VeiculoRepository> implements IVeiculoService {

}
