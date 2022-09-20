package br.edu.infnet.atfundjava2.repository;


import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.edu.infnet.atfundjava2.model.Balcao;

@Repository
public interface BalcaoRepository extends CrudRepository<Balcao, Integer> {
	@Query("from Balcao b where b.cliente.id = :idcliente")
	Collection<Balcao> findAll(Integer idcliente, Sort by);
	
	
	
}
