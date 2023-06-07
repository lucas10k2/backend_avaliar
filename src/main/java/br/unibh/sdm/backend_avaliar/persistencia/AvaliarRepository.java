package br.unibh.sdm.backend_avaliar.persistencia;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.backend_avaliar.entidades.Avaliar;

public interface AvaliarRepository extends CrudRepository<Avaliar, Long> {
	
	List<Avaliar> findByNome(String nome);
	
	Avaliar findById(long id);
	

	
}
