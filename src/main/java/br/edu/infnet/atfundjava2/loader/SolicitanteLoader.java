package br.edu.infnet.atfundjava2.loader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Solicitante;
import br.edu.infnet.atfundjava2.service.SolicitanteService;


@Component
public class SolicitanteLoader implements ApplicationRunner {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setId(1);

		Solicitante solicitante = new Solicitante("andre", "andre@anndre", "134.456.789-12");
		solicitante.setCliente(cliente);
		
		solicitanteService.incluir(solicitante);
	}

}