package br.com.indepdevbr.services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;

@Repository
public interface SolicitacaoVinculoTransportadoraMotoristaRepository 
		extends JpaRepository<SolicitacaoVinculoTransportadoraMotorista, Long> {
	
	public Optional<SolicitacaoVinculoTransportadoraMotorista> findByIdAndMotoristaId(Long id, Long motoristaId);
	
	public List<SolicitacaoVinculoTransportadoraMotorista> findByMotoristaId(Long motoristaId);

}
