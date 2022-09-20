package br.edu.infnet.atfundjava2.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.edu.infnet.atfundjava2.model.Externa;



@Repository
public interface ExternaRepository extends CrudRepository<Externa, Integer> {
	@Query("from Externa e where e.cliente.id = :idcliente")
	Collection<Externa> findAll(Integer idcliente, Sort by);

}