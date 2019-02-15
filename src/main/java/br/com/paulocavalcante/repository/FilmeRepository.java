package br.com.paulocavalcante.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.paulocavalcante.model.FilmeModel;

public interface FilmeRepository extends CrudRepository<FilmeModel, Long>{
	
	
}
