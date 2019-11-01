package br.com.indepdevbr.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByCodLogin(String codLogin);
	
	public boolean existsByCodLogin(String codLogin);


}
