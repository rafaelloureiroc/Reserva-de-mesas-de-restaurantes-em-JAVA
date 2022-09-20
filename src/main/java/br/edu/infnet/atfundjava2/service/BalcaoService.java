package br.edu.infnet.atfundjava2.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.repository.BalcaoRepository;

@Service
public class BalcaoService {
	
	@Autowired
	private BalcaoRepository balcaoRepository;
	
	public Collection<Balcao> obterLista(Cliente cliente) {
		return (Collection<Balcao>) balcaoRepository.findAll(cliente.getId(), Sort.by(Sort.Direction.ASC, "petisco")); 
	}	

	public Collection<Balcao> obterLista() {
		return (Collection<Balcao>) balcaoRepository.findAll(); 
	}		
}