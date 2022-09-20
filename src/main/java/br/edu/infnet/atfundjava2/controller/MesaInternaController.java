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
import br.edu.infnet.atfundjava2.model.MesaInterna;
import br.edu.infnet.atfundjava2.model.tipo.EnumBody;
import br.edu.infnet.atfundjava2.service.LocalService;
import br.edu.infnet.atfundjava2.service.MesaInternaService;

@Controller
public class MesaInternaController {

	@Autowired
	private MesaInternaService mesaInternaService;
	@Autowired
	private LocalService localService;

	@GetMapping(value = "/mesaInternas")
	public String telaLista(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("mesaInternaLista", mesaInternaService.obterLista());

		return "mesaInterna/lista";
	}

	@GetMapping(value = "/mesaInterna")
	public String telaRegistro() {
		return "mesaInterna/registro";
	}

	@PostMapping(value = "/mesaInterna/incluir")
	public String incluir(Model model, MesaInterna mesaInterna, @SessionAttribute("client") Cliente cliente) {

		mesaInterna.setTipo(EnumBody.MESAINTERNA);

		mesaInterna.setCliente(cliente);

		localService.incluir(mesaInterna);

		model.addAttribute("mensagem", "A mesa interna foi incluída com sucesso!");

		return telaLista(model, cliente);
	}

	@GetMapping(value = "/mesaInterna/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("client") Cliente cliente) {
		MesaInterna mesaInterna = (MesaInterna) localService.obterPorId(id);
		if (mesaInterna != null) {
			try {
				localService.excluir(id);
				model.addAttribute("mensagem", "A MesaInterna  foi excluída com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem",
						
						"Impossível realizar a exclusão! a mesaInterna está associado a uma mesa do restaurante!!!");
			}
		} else {
			model.addAttribute("mensagem", "MesaInterna inexistente.. impossível realizar a exclusão!!!");
		}

		return telaLista(model, cliente);

	}
}