package br.com.indepdevbr.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.indepdevbr.models.Marca;
import br.com.indepdevbr.models.Modelo;
import br.com.indepdevbr.models.Motorista;
import br.com.indepdevbr.models.Veiculo;
import br.com.indepdevbr.models.VinculoMotoristaVeiculo;
import br.com.indepdevbr.models.exception.ErroInternoException;
import br.com.indepdevbr.models.exception.RecursoNaoEncontradoException;
import br.com.indepdevbr.services.IVeiculoService;
import br.com.indepdevbr.services.abs.SuperClasse;
import br.com.indepdevbr.services.repository.VeiculoRepository;
import br.com.indepdevbr.services.repository.VinculoMotoristaVeiculoRepository;

@Service
public class VeiculoServiceImp extends SuperClasse<VeiculoRepository> implements IVeiculoService {
	
	
	@Autowired
	private MotoristaServiceImp motoristaServiceImp;
	
	@Autowired
	private MarcaServiceImp marcaServiceImp;
	
	@Autowired
	private ModeloServiceImp modeloServiceImp;
	
	@Autowired
	private VinculoMotoristaVeiculoRepository vinculoMotoristaVeiculoRepository;
	
	@Override
	public Veiculo inserir(Long idMotorista, Veiculo veiculo) {
		try {
			Motorista motorista = motoristaServiceImp.buscarPorId(idMotorista);
			Marca marca = marcaServiceImp.buscarPorId(veiculo.getMarca().getId());
			Modelo modelo = modeloServiceImp.buscarPorIdEIdMarca(veiculo.getModelo().getId(), marca.getId());
			veiculo.setMarca(marca);
			veiculo.setModelo(modelo);
			Veiculo veiculoPersist = repository.save(veiculo);
			VinculoMotoristaVeiculo vinculo = new VinculoMotoristaVeiculo(motorista, motorista, veiculoPersist);
			vinculo = vinculoMotoristaVeiculoRepository.save(vinculo);
			return veiculoPersist;
		} catch (Exception e) {
			if(e instanceof RecursoNaoEncontradoException) {
				throw e;
			} else {
				throw new ErroInternoException("Ocorreu um erro ao processar a requisição", e);
			}
		}
	}
	
}
