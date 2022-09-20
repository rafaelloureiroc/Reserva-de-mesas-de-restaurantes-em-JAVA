  package br.edu.infnet.atfundjava2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.service.ClienteService;



@SessionAttributes("client")
@Controller
public class LoginController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/")
	public String telaHome() {
		return "home";		
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";		
	}

	@GetMapping(value = "/logout")
	public String logout(SessionStatus status, HttpSession session) {
		
		status.setComplete();
		session.removeAttribute("client");
		
		return "redirect:/";		
	}

	@PostMapping(value = "/login")
	public String validar(Model model, @RequestParam String email, @RequestParam String senha){
		
		Cliente cliente= clienteService.autenticacao(email, senha);

		if(cliente != null) {
			model.addAttribute("client", cliente);
			
			return "redirect:/";
		} else {
			model.addAttribute(
					"mensagem", 
					"As credenciais do cliente "+ email +" estao incorretas!!!"
				);

			return telaLogin();
		}	

	}
}
