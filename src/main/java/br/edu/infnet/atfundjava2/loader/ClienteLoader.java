package br.edu.infnet.atfundjava2.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.service.ClienteService;







@Component
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Cliente cliente = new Cliente();
		cliente.setNome("Rafael Loureiro");
		cliente.setEmail("rafa@rafa.com");
		cliente.setSenha("0000");
		cliente.setAdmin(true);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("joao Loureiro");
		cliente2.setEmail("joao@rafa.com");
		cliente2.setSenha("1234");
		cliente2.setAdmin(false);
		
		

		clienteService.incluir(cliente);
	}
}