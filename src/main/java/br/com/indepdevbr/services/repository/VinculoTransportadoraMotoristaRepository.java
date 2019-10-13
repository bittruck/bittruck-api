package br.com.indepdevbr.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.VinculoTransportadoraMotorista;

@Repository
public interface VinculoTransportadoraMotoristaRepository 
		extends JpaRepository<VinculoTransportadoraMotorista, Long> {

}
