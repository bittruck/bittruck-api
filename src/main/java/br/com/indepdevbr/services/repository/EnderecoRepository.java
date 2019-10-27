package br.com.indepdevbr.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.indepdevbr.models.Endereco;

@Repository(value = "EnderecoRepository")
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	public List<Endereco> findByCodCep(String codCep);
	
	public List<Endereco> findByNomEstadoAndNomCidadeAndDesLogradouro(String nomEstado, String nomCidade, String desLogradouro);
	
}
