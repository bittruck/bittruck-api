package br.com.indepdevbr.services;

import br.com.indepdevbr.models.Usuario;

public interface IUsuarioService {
	
	public Usuario inserir(Usuario usuario);
	
	public Usuario buscarPorCodLogin(String codLogin);
	
	public Usuario validarUsuario(Usuario usuario);
	
}
