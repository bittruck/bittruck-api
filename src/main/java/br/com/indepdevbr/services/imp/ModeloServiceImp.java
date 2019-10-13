package br.com.indepdevbr.services.imp;

import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.IModeloService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.ModeloRepository;

@Service
public class ModeloServiceImp extends SuperClasse<ModeloRepository> implements IModeloService {

}
