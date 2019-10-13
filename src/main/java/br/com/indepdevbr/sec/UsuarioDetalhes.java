package br.com.indepdevbr.sec;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.indepdevbr.models.Usuario;

public class UsuarioDetalhes implements UserDetails {

	private static final long serialVersionUID = -3920606885441264099L;
	
	private String codLogin;
	
	private String desSenha;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioDetalhes() {
		
	}
	
	public UsuarioDetalhes(String codLogin, String desSenha, Collection<? extends GrantedAuthority> authorities) {
		this.codLogin = codLogin;
		this.desSenha = desSenha;
		this.authorities = authorities;
	}
	
	public static UsuarioDetalhes gerar(Usuario usuario) {
		List<GrantedAuthority> authorities = 
				Arrays.asList(usuario.getTpoPermissao())
					.stream()
					.map( permissao -> new SimpleGrantedAuthority(permissao.name()))
					.collect(Collectors.toList());
		return new UsuarioDetalhes(usuario.getCodLogin(), 
								   usuario.getDesSenha(), 
								   authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return desSenha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return codLogin;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
