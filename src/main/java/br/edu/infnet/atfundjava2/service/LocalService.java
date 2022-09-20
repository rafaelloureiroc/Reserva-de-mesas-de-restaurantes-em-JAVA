package br.edu.infnet.atfundjava2.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Local;
import br.edu.infnet.atfundjava2.repository.LocalRepository;



@Service
public class LocalService {

	@Autowired
	private LocalRepository localRepository;
	
	public void incluir(Local local) {
		localRepository.save(local);
	}

	public void excluir(Integer id) {
		localRepository.deleteById(id);
	}

	public Local obterPorId(Integer id) {
		return localRepository.findById(id).orElse(null);
	}
	public Collection<Local> obterLista(Cliente cliente) {
		return (Collection<Local>) localRepository.findAll(cliente.getId(), Sort.by(Sort.Direction.ASC, "id")); 
	}

	public Collection<Local> obterLista() {
		return (Collection<Local>) localRepository.findAll(); 
	}	
}
