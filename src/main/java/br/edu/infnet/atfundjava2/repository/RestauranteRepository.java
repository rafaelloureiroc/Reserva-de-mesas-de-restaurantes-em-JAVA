package br.edu.infnet.atfundjava2.repository;

import java.util.Collection;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import br.edu.infnet.atfundjava2.model.Restaurante;


@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Integer> {
	@Query("from Restaurante r where r.cliente.id = :idcliente")
	Collection<Restaurante> findAll(Integer idcliente, Sort by);
	
	Collection<Restaurante> findAll(Sort by);
}
