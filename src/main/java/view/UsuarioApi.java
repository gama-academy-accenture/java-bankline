package view;

import java.util.List;

import dao.UsuarioRepository;
import model.Usuario;
//teste
public class UsuarioApi {

		static UsuarioRepository repository = new UsuarioRepository();  
		
		public static void main(String[] args) {
			save();
			//update();
			//list();
		}
		static void save() {
			Usuario usuario = new Usuario();
			usuario.setNome("Teste");
			usuario.setCpf("333222111");
			usuario.setLogin("testandoTudo");
			usuario.setSenhaEncriptada("123"); 
			repository.save(usuario);  
		}
		static void update() {
			Object idUsuarioQueSalvouNaBase = 1; //mudar
			
			Usuario usuario = repository.find(idUsuarioQueSalvouNaBase);  
			
			if(usuario!=null) {
				usuario.setLogin("aindaTeste");
				usuario.setSenhaEncriptada("555"); 
				usuario.setNome("T");
				usuario.setCpf("333222888");
				repository.update(usuario);  
			}
		}
		
		static void list() {
			System.out.println("LISTANDO Usuarios");
			
			List<Usuario> usuarios = repository.list();
			
			for(Usuario u: usuarios) {
				System.out.println(u);    
			}
		}

}
