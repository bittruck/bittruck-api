package br.com.indepdevbr.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.SolicitacaoVinculoTransportadoraMotorista;

@Repository
public interface SolicitacaoVinculoTransportadoraMotoristaRepository 
		extends JpaRepository<SolicitacaoVinculoTransportadoraMotorista, Long> {

}
