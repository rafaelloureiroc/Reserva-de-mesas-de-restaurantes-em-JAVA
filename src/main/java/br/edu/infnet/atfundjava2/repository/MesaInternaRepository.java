package br.edu.infnet.atfundjava2.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.edu.infnet.atfundjava2.model.MesaInterna;



@Repository
public interface MesaInternaRepository extends CrudRepository<MesaInterna, Integer> {
	@Query("from MesaInterna m where m.cliente.id = :idcliente")
	Collection<MesaInterna> findAll(Integer idcliente, Sort by);
}