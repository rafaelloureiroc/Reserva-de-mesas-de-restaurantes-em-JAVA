package br.edu.infnet.atfundjava2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/cliente")
	public String telaCadastro() {
		return "cliente/registro";
	}

	@GetMapping(value = "/clientes")
	public String telaLista(Model model) {

		model.addAttribute("clienteLista", clienteService.obterLista());

		return "cliente/lista";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente) {

		clienteService.incluir(cliente);

		return "redirect:/";
	}

	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) throws InterruptedException {

		Cliente cliente = clienteService.obterPorId(id);
		
		if (cliente != null) {
			clienteService.excluir(id);

			model.addAttribute("mensagem", "O cliente foi excluido");
		} else {
			model.addAttribute("mensagem", "Cliente inexistente.. logo, nao ha exclusao a fazer");
		}

		return telaLista(model);
	}
}
