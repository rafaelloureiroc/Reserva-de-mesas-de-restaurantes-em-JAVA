package br.edu.infnet.atfundjava2.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.repository.ExternaRepository;


@Service
public class ExternaService {
	
	@Autowired
	private ExternaRepository externaRepository;
	public Collection<Externa> obterLista(Cliente cliente) {
		return (Collection<Externa>) externaRepository.findAll(cliente.getId(), Sort.by(Sort.Direction.ASC, "id")); 
	}	

	public Collection<Externa> obterLista() {
		return (Collection<Externa>) externaRepository.findAll(); 
	}		
}