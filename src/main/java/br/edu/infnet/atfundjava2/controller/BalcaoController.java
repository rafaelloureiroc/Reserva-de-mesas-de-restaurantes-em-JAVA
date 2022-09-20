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
import br.edu.infnet.atfundjava2.model.tipo.EnumBody;
import br.edu.infnet.atfundjava2.service.BalcaoService;
import br.edu.infnet.atfundjava2.service.LocalService;

@Controller
public class BalcaoController {

	@Autowired
	private BalcaoService balcaoService;
	@Autowired
	private LocalService localService;

	@GetMapping(value = "/balcoes")
	public String telaLista(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("balcaoLista", balcaoService.obterLista(cliente));

		return "balcao/lista";
	}

	@GetMapping(value = "/balcao")
	public String telaRegistro() {
		return "balcao/registro";
	}

	@PostMapping(value = "/balcao/incluir")
	public String incluir(Model model, Balcao balcao, @SessionAttribute("client") Cliente cliente) {

		balcao.setTipo(EnumBody.BALCAO);

		balcao.setCliente(cliente);

		localService.incluir(balcao);

		model.addAttribute("mensagem", "O balcao foi incluída com sucesso!");

		return telaLista(model, cliente);
	}

	@GetMapping(value = "/balcao/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("client") Cliente cliente) {

		Balcao balcao = (Balcao) localService.obterPorId(id);
		if (balcao != null) {
			try {
				localService.excluir(id);
				model.addAttribute("mensagem", "A balcao  foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! O balcao está associado a uma mesa do restaurante!!!");
			}
		} else {
			model.addAttribute("mensagem", "balcao inexistente.. impossível realizar a exclusão!!!");
		}

		return telaLista(model, cliente);
	}
}