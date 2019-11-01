package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Usuario;
import br.com.indepdevbr.models.exception.BittruckException;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IUsuarioService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp extends SuperClasse<UsuarioRepository> implements IUsuarioService {
		
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public Usuario inserir(Usuario usuario) {
		try {
			logger.info("metodo=inserir, " + usuario);
			usuario.setDesSenha(passwordEncoder.encode(usuario.getDesSenha()));
			return repository.save(usuario);
		} catch (Exception e) {
			logger.error("metodo=inserir, throw=" + e.getMessage(), e);
			throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
		}
	}

	@Override
	public Usuario buscarPorCodLogin(String codLogin) {
		try {
			Usuario usuario = repository.findByCodLogin(codLogin)
					.map( u -> {
						return u;
					}).orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum usuário encontradpo pelo codLogin: " + codLogin));
			return usuario;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public Usuario validarUsuario(Usuario usuario) {
		try {
			Usuario usuarioPersist = repository.findByCodLogin(usuario.getCodLogin())
						.map(u -> {
							return u;
						}).orElseThrow(() -> new RecursoNaoEncontradoException("Combinação usuário e senha inválida"));
			if(passwordEncoder.matches(usuario.getDesSenha(), usuarioPersist.getDesSenha()))
				return usuarioPersist;
			else
				throw new BittruckException("Combinação usuário e senha inválida");
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new BittruckException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

	@Override
	public void atualizar(Usuario usuario) {
		try {
			if(!repository.existsByCodLogin(usuario.getCodLogin())) {
				throw new RecursoNaoEncontradoException("Nenhum usuário encontradpo pelo codLogin: ");
			}
			repository.save(usuario);
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}

}
