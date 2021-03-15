package com.javamos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamos.model.Conta;
import com.javamos.model.Usuario;
import com.javamos.model.enuns.TiposDeConta;
import com.javamos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository rep;
	
	@Autowired
	private ContaService contaServ;
	
	public List<Usuario> usuarios(){
		return rep.findAll();
	}
	public List<Conta> contas(Usuario usuario){
		return contaServ.contasPorUsuario(usuario);// contaRep.findByUsuarioId(id);
	} 
	
	@Transactional
	public void salvar(Usuario usuario) {

		if(rep.existsByLogin(usuario.getLogin()))
			throw new IllegalArgumentException("Já existe um usuário com este login " + usuario.getLogin());
		
		rep.save(usuario);
		
		Conta cBanco = new Conta(TiposDeConta.ContaBanco, usuario);
		
		Conta cCredito = new Conta(TiposDeConta.ContaCredito, usuario);

		contaServ.salvar(cBanco);
		contaServ.salvar(cCredito);
	}
	
	@Transactional
	public void atualizar(Usuario usuario) {
		rep.save(usuario);
	}
  
}
