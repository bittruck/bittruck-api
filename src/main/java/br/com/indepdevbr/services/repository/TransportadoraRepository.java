package br.com.indepdevbr.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Transportadora;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

}
