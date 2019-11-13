package br.com.indepdevbr.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.VinculoTransportadoraMotorista;

@Repository
public interface VinculoTransportadoraMotoristaRepository 
		extends JpaRepository<VinculoTransportadoraMotorista, Long> {

	public List<VinculoTransportadoraMotorista> findByMotoristaId(Long motoristaId);
	
}
