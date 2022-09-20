package br.edu.infnet.atfundjava2.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.atfundjava2.model.Balcao;
import br.edu.infnet.atfundjava2.model.Cliente;
import br.edu.infnet.atfundjava2.model.Externa;
import br.edu.infnet.atfundjava2.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente autenticacao(String email, String senha) {
		return clienteRepository.autenticacao(email, senha);
	}

	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public Collection<Cliente> obterLista(Cliente cliente) {
		return (Collection<Cliente>) clienteRepository.findAll(cliente.getId(), Sort.by(Sort.Direction.ASC, "id"));
	}

	public Collection<Cliente> obterLista() {
		return (Collection<Cliente>) clienteRepository.findAll();
	}

	public Cliente obterPorId(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
}
