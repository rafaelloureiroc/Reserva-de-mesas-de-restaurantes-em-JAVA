package br.edu.infnet.atfundjava2.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.model.MesaInterna;
import br.edu.infnet.atfundjava2.model.tipo.EnumBody;
import br.edu.infnet.atfundjava2.service.LocalService;



@Component
public class LocalLoader implements ApplicationRunner {

	@Autowired
	private LocalService localService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Cliente cliente= new Cliente();
		cliente.setId(1);

		Balcao balcao = new Balcao(2, false,"madeira");
        balcao.setBebidaAlcoolica("Whiskey");
        balcao.setPetisco("Batata frita");
        balcao.setShotsAlcoolicos(6);
        balcao.setCliente(cliente);
        balcao.setTipo(EnumBody.BALCAO);
		localService.incluir(balcao);
		
		Externa externa = new Externa( 4, true, "aço");
        externa.setQntdVentiladores(3);
        externa.setCadeiraAcolchoada(true);
        externa.setMusico("Jota Quest");
        externa.setCliente(cliente);
        externa.setTipo(EnumBody.MESAEXTERNA);
		localService.incluir(externa);
		
		MesaInterna interna = new MesaInterna(8, true, "ferro");
        interna.setVelaRomantica(true);
        interna.setArCondicionado(false);
        interna.setIluminacaoEspecial("Vermelho rose");
        interna.setCliente(cliente);
        interna.setTipo(EnumBody.MESAINTERNA);
		localService.incluir(interna);
	}
}