package br.edu.infnet.atfundjava2.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Restaurante;

import br.edu.infnet.atfundjava2.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public Collection<Restaurante> obterLista(Cliente cliente){		
		return (Collection<Restaurante>) restauranteRepository.findAll(cliente.getId(), Sort.by(Sort.Direction.ASC, "id"));	

	}

	public Collection<Restaurante> obterLista(){		
		return (Collection<Restaurante>) restauranteRepository.findAll();
	}
	
	public Restaurante incluir(Restaurante restaurante){
		return restauranteRepository.save(restaurante);
	}
	
	public void excluir(Integer id) {
		restauranteRepository.deleteById(id);
	}
	
	public Restaurante obterPorId(Integer id) {
		return restauranteRepository.findById(id).orElse(null);
	}	
}