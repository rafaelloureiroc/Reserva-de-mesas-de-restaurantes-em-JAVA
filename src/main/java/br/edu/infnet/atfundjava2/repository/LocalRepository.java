package br.edu.infnet.atfundjava2.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atfundjava2.model.Local;




@Repository
public interface LocalRepository extends CrudRepository<Local, Integer> {
	 @Query("from Local l where l.cliente.id = :idcliente")	
	Collection<Local> findAll(Integer idcliente, Sort by);
	
	Collection<Local> findAll(Sort by);
}
