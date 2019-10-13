package br.com.indepdevbr.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
