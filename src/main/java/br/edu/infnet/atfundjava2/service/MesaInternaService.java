package br.edu.infnet.atfundjava2.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.MesaInterna;
import br.edu.infnet.atfundjava2.repository.MesaInternaRepository;

@Service
public class MesaInternaService {

	@Autowired
	private MesaInternaRepository mesaInternaRepository;

	public Collection<MesaInterna> obterLista() {
		return (Collection<MesaInterna>) mesaInternaRepository.findAll();
	}
	public Collection<MesaInterna> obterLista(Cliente cliente) {
		return (Collection<MesaInterna>) mesaInternaRepository.findAll(cliente.getId(), Sort.by(Sort.Direction.ASC, "id")); 
	}	
}