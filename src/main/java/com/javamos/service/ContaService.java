package com.javamos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamos.model.Conta;
import com.javamos.model.Usuario;
import com.javamos.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRep;
	
	public void salvar(Conta conta) {
		conta.setNumero(conta.getUsuario().getLogin() + conta.getTipoDeConta().getTipo());
		contaRep.save(conta);
	}

	public List<Conta> contasPorUsuario(Usuario usuario) {
		return contaRep.findByUsuarioId(usuario.getId());
	}
  
}
