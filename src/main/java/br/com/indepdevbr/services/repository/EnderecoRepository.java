package br.com.indepdevbr.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Endereco;

@Repository(value = "EnderecoRepository")
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
