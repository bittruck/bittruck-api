package br.com.indepdevbr.services.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
	
	public Optional<Operador> findByDesEmail(String desEmail);
	
	public Optional<Operador> findByIdAndTransportadoraId(Long id, Long transportadoraId);
	
	public Page<Operador> findByTransportadoraId(Long trasportadoraId, Pageable pageable);
	
}
