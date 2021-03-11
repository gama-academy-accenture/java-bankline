package controller;

import exceptions.SessaoEncerradaException;
import model.Usuario;

public class UsuarioService {
	
	private static Usuario usuarioAtual;
	
	public static Usuario getUsuarioAtual() {
		if(usuarioAtual != null)
			return usuarioAtual;
		throw new SessaoEncerradaException("Sua seção expirou!");
	}
	
	public UsuarioService() {
		
	}

}
