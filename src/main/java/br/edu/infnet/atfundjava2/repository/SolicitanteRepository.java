package br.edu.infnet.atfundjava2.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atfundjava2.model.Solicitante;


@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante, Integer> {

	@Query("from Solicitante s where s.cliente.id = :idcliente")
	public List<Solicitante> obterLista(Integer idcliente, Sort sort);
}