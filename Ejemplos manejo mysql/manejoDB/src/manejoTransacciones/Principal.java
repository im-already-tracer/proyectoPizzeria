package manejoTransacciones;
import java.util.*;
import java.sql.*;


public class Principal {

	public static void main(String[] args) {

		
		Connection conexion = null;
	//tenemos la conexion afuera de dao
		try {
		  conexion = Conexion.getConexion();
		
		if(conexion.getAutoCommit()) conexion.setAutoCommit(false);	//necesitamos que la conexion no haga el auto comit de forma automatica
		
		
		PersonaDAO personaDao = new PersonaDAO(conexion);
//String nombre, String apellido, String email, String telefono) 
		Persona persona = new Persona(4,"Juana", "Sabalera", "JSabalera@mail.com", "121212");
		
		personaDao.actualizar(persona);
		
		Persona persona2 = new Persona("Alberto", "Sabalero", "ASabalero@mail.com", "131312");
		
		
		personaDao.insertar(persona2);
		
		
		List<Persona> personas = personaDao.seleccionar();
		
	/*	personas.forEach(a->{
			System.out.println(a.toString());
		});
		*/
		conexion.commit();//si todo sale bien hacemos el commit, en caso de error no se hace nada
		
		} catch (SQLException e) {
			
			
			e.printStackTrace(System.out);
			System.out.println("Entramos en rollback");	//si ocurrio un error, no realizamos nada
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			}
		}
		
	
		
	}
	
		
}
