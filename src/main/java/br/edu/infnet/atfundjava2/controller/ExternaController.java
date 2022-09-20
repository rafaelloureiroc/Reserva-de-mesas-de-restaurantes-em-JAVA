package br.edu.infnet.atfundjava2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.model.tipo.EnumBody;
import br.edu.infnet.atfundjava2.service.ExternaService;
import br.edu.infnet.atfundjava2.service.LocalService;

@Controller
public class ExternaController {

	@Autowired
	private ExternaService externaService;
	@Autowired
	private LocalService localService;

	@GetMapping(value = "/externas")
	public String telaLista(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("externaLista", externaService.obterLista());

		return "externa/lista";
	}

	@GetMapping(value = "/externa")
	public String telaRegistro() {
		return "externa/registro";
	}

	@PostMapping(value = "/externa/incluir")
	public String incluir(Model model, Externa externa, @SessionAttribute("client") Cliente cliente) {

		externa.setTipo(EnumBody.MESAEXTERNA);

		externa.setCliente(cliente);

		localService.incluir(externa);

		model.addAttribute("mensagem", "A externa  foi incluída com sucesso!");

		return telaLista(model, cliente);
	}

	@GetMapping(value = "/externa/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("client") Cliente cliente) {
		Externa externa = (Externa) localService.obterPorId(id);
		if (externa != null) {
			try {
				localService.excluir(id);
				model.addAttribute("mensagem", "A externa  foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem",
						"Impossível realizar a exclusão! A externa está associado a uma mesa do restaurante!!!");
			}
		} else {
			model.addAttribute("mensagem", "externa inexistente.. impossível realizar a exclusão!!!");
		}

		return telaLista(model, cliente);
	}
}
