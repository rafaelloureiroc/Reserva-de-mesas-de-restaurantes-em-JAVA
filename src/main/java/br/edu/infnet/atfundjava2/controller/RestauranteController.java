package br.edu.infnet.atfundjava2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Local;
import br.edu.infnet.atfundjava2.model.Restaurante;
import br.edu.infnet.atfundjava2.service.LocalService;
import br.edu.infnet.atfundjava2.service.RestauranteService;
import br.edu.infnet.atfundjava2.service.SolicitanteService;

@Controller
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService; 
	@Autowired
	private SolicitanteService solicitanteService;
	@Autowired
	private LocalService localService; 

	@GetMapping(value = "/restaurante")
	public String telaRegistro(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("solicitanteLista", solicitanteService.obterLista(cliente));

		model.addAttribute("localLista", localService.obterLista(cliente));

		return "restaurante/registro";
	}

	@GetMapping(value = "/restaurantes")
	public String telaLista(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("restauranteLista", restauranteService.obterLista(cliente));

		return "restaurante/lista";
	}

	@PostMapping(value = "/restaurante/incluir")
	public String incluir(@RequestParam String[] idsLocais, Restaurante restaurante, Model model,
			@SessionAttribute("client") Cliente cliente) {

		List<Local> locais = new ArrayList<Local>();

		for (String idLocal : idsLocais) {

			Local local = localService.obterPorId(Integer.valueOf(idLocal));

			locais.add(local);
		}

		restaurante.setCliente(cliente);

		restaurante.setLocais(locais);

		restauranteService.incluir(restaurante);

		model.addAttribute("mensagem", "A mesa no restaurante " + restaurante.getDescricao() + " foi incluída com sucesso!!!");

		return telaLista(model, cliente);
	}

	@GetMapping(value = "/restaurante/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("client") Cliente cliente) {

		Restaurante restaurante = restauranteService.obterPorId(id);

		if (restaurante != null) {
			restauranteService.excluir(id);
			model.addAttribute("mensagem", "A reserva de mesa " + restaurante.getDescricao() + " foi excluída com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Mesa inexistente no restaurante.. impossível realizar a exclusão!!!");
		}

		return telaLista(model, cliente);
	}
}
