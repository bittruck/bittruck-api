package br.com.indepdevbr.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.services.imp.UsuarioServiceImp;

@Service
public class UsuarioDetalhesServiceImp implements UserDetailsService {

	@Autowired
	private UsuarioServiceImp usuarioServiceImp;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = UsuarioDetalhes.gerar(usuarioServiceImp.buscarPorCodLogin(username));
		return userDetails;
	}

}
