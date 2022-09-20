package br.edu.infnet.atfundjava2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.model.Local;
import br.edu.infnet.atfundjava2.service.LocalService;

@Controller
public class LocalController {

	@Autowired
	private LocalService localService;

	@GetMapping(value = "/locais")
	public String telaLista(Model model, @SessionAttribute("client") Cliente cliente) {

		model.addAttribute("localLista", localService.obterLista(cliente));

		return "local/lista";
	}

	@GetMapping(value = "/local/{id}/excluir")

	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("client") Cliente cliente) {

		Local local = localService.obterPorId(id);

		String tipoLocal = obterTipoLocal(local);

		if (local != null) {
			try {
				localService.excluir(id);
				model.addAttribute("mensagem", "A(O) " + tipoLocal + "  foi excluída(o) com sucesso!!!");
			} catch (Exception e) {
				model.addAttribute("mensagem",
						"Impossível realizar a exclusão! A(O) " + tipoLocal + "  está associada(o) a um pedido!!!");
			}
		} else {
			model.addAttribute("mensagem", "Local inexistente.. impossível realizar a exclusão!!!");
		}

		return telaLista(model, cliente);
	}

	private String obterTipoLocal(Local local) {
		String tipoLocal = null;

		if (local instanceof Balcao) {
			tipoLocal = "Balcao";
		} else if (local instanceof Externa) {
			tipoLocal = "Externa";
		} else {
			tipoLocal = "MesaInterna";
		}

		return tipoLocal;
	}
}
