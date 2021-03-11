package dao;

import model.Conta;
import model.Usuario;
import model.enumeracoes.TiposDeConta;

public class UsuarioRepository extends AbstractRepository<Usuario> implements Repository<Usuario>{
	/*
	public void saveUsuario(Usuario usuario) {
	  em.getTransaction().begin();
	  em.persist(usuario);
	  em.getTransaction().commit();
	  
	  ContaRepository contaRepository = new ContaRepository();
	  
	  Conta contaBanco = new Conta(TiposDeConta.ContaBanco,usuario.getId());
	  contaBanco.setSaldo(0.0);
	  contaBanco.setItens(null); 
	  contaBanco.setNumero("123456");  
	  contaRepository.save(contaBanco); 
	  
	  Conta contaCredito = new Conta(TiposDeConta.ContaBanco,usuario.getId());
	  contaBanco.setSaldo(0.0);
	  contaBanco.setItens(null); 
	  contaBanco.setNumero("654321");
	  contaRepository.save(contaBanco);     
  }
  */
}
