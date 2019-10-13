package br.com.indepdevbr.sec;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private UsuarioDetalhesServiceImp usuarioDetalhesServiceImp;
	
	@Autowired
	private GerenciadorTokenJWT gerenciadorTokenJWT;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestHeader = request.getHeader("Authorization");
		String codLogin = null;
		String tokenJWT = null;
		if(requestHeader != null && requestHeader.startsWith("Bearer ")) {
			tokenJWT = requestHeader.substring(7);
			codLogin = gerenciadorTokenJWT.capturarCodLoginTokenJWT(tokenJWT);
		}
		if(codLogin != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = usuarioDetalhesServiceImp.loadUserByUsername(codLogin);
			UsernamePasswordAuthenticationToken authentication = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}

}
