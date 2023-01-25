package udemy2;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
	
		List <Usuario> usuarios = new ArrayList<> ();
		
	/*	Usuario u1 = new Usuario("Tom1", "121888");
		Usuario u2 = new Usuario("Tom2", "1274352");
		Usuario u3 = new Usuario("Tom3", "12642");
		Usuario u4 = new Usuario("Tom4", "1234");

		
		
		
		usuarioDao.insertar(u1);
		usuarioDao.insertar(u2);
		usuarioDao.insertar(u3);
		usuarioDao.insertar(u4);
		*/
		UsuarioDao usuarioDao =  new UsuarioDao();
	
		usuarioDao.eliminar(1);
		
		usuarios = usuarioDao.seleccionar();
		Usuario usuarioActualizado = new Usuario(2,"Valentin", "9898");
		
	//	usuarioDao.actualizar(usuarioActualizado);
		
		
		usuarios.forEach(a->{
			
			System.out.println(a.toString());
			
		});
		
		
		
	}

}
