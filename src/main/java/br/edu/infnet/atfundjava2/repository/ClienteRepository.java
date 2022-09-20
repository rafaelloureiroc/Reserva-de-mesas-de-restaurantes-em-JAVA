package br.edu.infnet.atfundjava2.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Externa;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("from Cliente c where c.email = :email and c.senha = :senha")
	public Cliente autenticacao(String email, String senha);
	
	@Query("from Cliente c where c.id = :idcliente")
	Collection<Cliente> findAll(Integer idcliente, Sort by);
	

}