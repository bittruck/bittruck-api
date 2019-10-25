package br.com.indepdevbr.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;	 

	@Autowired
	private UsuarioDetalhesServiceImp usuarioDetalhesServiceImp;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(usuarioDetalhesServiceImp).passwordEncoder(passwordEncoder());
	}

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.cors()
				.and()
			.csrf().disable()
			.authorizeRequests()
				.antMatchers(
						"/autenticacao/login",
						"/cadastro/transportadora_operador",
						"/cadastro/motorista",
						"/transportadora/ativar",
						"/swagger-resources/configuration/ui",
						"/swagger-resources/configuration/security",
						"/csrf",
						"/v2/api-docs",
						"/swagger-ui.html"
						).permitAll()
				.anyRequest().authenticated()
					.and()
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
					.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);			
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/webjars/**");
    }

}
