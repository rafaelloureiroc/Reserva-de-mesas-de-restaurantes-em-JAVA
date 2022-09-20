package br.edu.infnet.atfundjava2.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Local;
import br.edu.infnet.atfundjava2.model.Restaurante;
import br.edu.infnet.atfundjava2.model.Solicitante;
import br.edu.infnet.atfundjava2.service.LocalService;
import br.edu.infnet.atfundjava2.service.RestauranteService;

@Component
public class RestauranteLoader implements ApplicationRunner {
	@Autowired
	private LocalService localService;
	@Autowired
	private RestauranteService restauranteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {
			List<Local> locais = new ArrayList<Local>(localService.obterLista());

			Solicitante solicitante = new Solicitante();
			solicitante.setId(1);

			Cliente cliente = new Cliente();
			cliente.setId(1);

			Restaurante restaurante = new Restaurante(solicitante);
			restaurante.setDescricao("Pedido do professor elberth");
			restaurante.setLocais(locais);
			restaurante.setCliente(cliente);

			restauranteService.incluir(restaurante);
		} catch (Exception e) {
			System.out.println("Impossível realizar a inclusão: " + e.getMessage());
		}
	}
}