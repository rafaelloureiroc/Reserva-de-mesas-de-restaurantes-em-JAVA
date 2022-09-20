package br.edu.infnet.atfundjava2.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Solicitante;
import br.edu.infnet.atfundjava2.repository.SolicitanteRepository;


@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;

	public Collection<Solicitante> obterLista(Cliente cliente){		
		return (Collection<Solicitante>) solicitanteRepository.obterLista(cliente.getId(),  Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Collection<Solicitante> obterLista(){		
		return (Collection<Solicitante>) solicitanteRepository.findAll();
	}
	
	public Solicitante incluir(Solicitante solicitante){
		return solicitanteRepository.save(solicitante);
	}
	
	public void excluir(Integer id) {
		solicitanteRepository.deleteById(id);
	}
	
	public Solicitante obterPorId(Integer id) {
		return solicitanteRepository.findById(id).orElse(null);
	}
}