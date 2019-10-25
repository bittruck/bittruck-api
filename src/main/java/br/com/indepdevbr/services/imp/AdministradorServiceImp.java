package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Administrador;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.services.IAdministradorService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.AdministradorRepository;

@Service
public class AdministradorServiceImp extends SuperClasse<AdministradorRepository> implements IAdministradorService {

	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Override
	public Administrador inserir(Administrador administrador) {
		try {
			administrador.setUsuario(usuarioServiceImp.inserir(administrador.getUsuario()));
			Administrador admin = repository.save(administrador);
			return admin;
		} catch (Exception e) {
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

}
