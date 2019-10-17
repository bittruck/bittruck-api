package br.com.indepdevbr.services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	
	public Optional<Modelo> findByIdAndMarcaId(Long id, Long marcaId);
	
	public Page<Modelo> findByMarcaId(Long marcaId, Pageable pageable);
	
	public boolean existsByIdAndMarcaId(Long id, Long marcaId);
	
	public List<Modelo> findByMarcaIdAndNomModeloContaining(Long marcaId, String nomModelo);
	
}
