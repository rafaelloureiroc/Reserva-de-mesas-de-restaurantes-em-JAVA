package br.edu.infnet.atfundjava2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Solicitante;
import br.edu.infnet.atfundjava2.service.SolicitanteService;

@Controller
public class SolicitanteController {

	@Autowired
	private SolicitanteService solicitanteService;

	@GetMapping(value = "/solicitante")
	public String telaRegistro() {
		return "solicitante/registro";
	}

	@GetMapping(value = "/solicitantes")
	public String telaLista(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("solicitanteLista", solicitanteService.obterLista(cliente));

		return "solicitante/lista";
	}

	@PostMapping(value = "/solicitante/incluir")
	public String incluir(Solicitante solicitante, Model model, @SessionAttribute("client") Cliente cliente) {

		solicitante.setCliente(cliente);

		solicitanteService.incluir(solicitante);

		model.addAttribute("mensagem", "O solicitante " + solicitante.getNome() + " foi incluído com sucesso!!!");

		return telaLista(model, cliente);
	}

	@GetMapping(value = "/solicitante/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("client") Cliente cliente) {

		Solicitante solicitante = solicitanteService.obterPorId(id);

		if (solicitante != null) {
			try {
				solicitanteService.excluir(id);
				model.addAttribute("mensagem",
						"O solicitante " + solicitante.getNome() + " foi excluído com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem", "Impossível realizar a exclusão! O solicitante " + solicitante.getNome()
						+ " está associado a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Solicitante inexistente.. impossível realizar a exclusão!!!");
		}
		return telaLista(model, cliente);
	}
}