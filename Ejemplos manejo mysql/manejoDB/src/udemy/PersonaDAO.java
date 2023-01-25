package udemy;
import java.util.*;

import static manejoTransacciones.Conexion.*;

import java.sql.*;
public class PersonaDAO {

	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre = ? ,apellido = ?, email = ? , telefono = ? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
	
	
	//UPDATE persona SET nombre = "Thiago", apellido = "Nuevo", email = "TNuevo@gmail.com", telefono = "12121" WHERE id_persona = 6;
	public PersonaDAO() {
		// TODO Auto-generated constructor stub
	}

	
	public List<Persona> seleccionar(){
		
		Connection con = null;
		PreparedStatement stm = null;
		
		ResultSet rs = null;
		
		Persona persona = null;
		
		List<Persona> personas = new ArrayList<> ();
	
		try {

			con = getConexion();	//importe Conexion como estatico, por lo tanto no hace falta llamarlo
			stm = con.prepareStatement(SQL_SELECT);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				
				int id_Persona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				
				persona = new Persona(id_Persona,nombre,apellido,email,telefono);
				personas.add(persona);
			}
			
		}catch(SQLException e){
			
			
			e.printStackTrace(System.out);
			
		}finally {
			
			try {
				
				close(rs);
				close(stm);
				close(con);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		return personas;
	}
	
	
	public int insertar(Persona p)  {
		Connection con = null;
		PreparedStatement  stmt = null;
		int registros = 0;
		
		try {
			con = getConexion();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getEmail());
			stmt.setString(4, p.getTelefono());
			registros = stmt.executeUpdate();	//INSERT, UPDATE Y DELETE PUEDE REALIZAR ESTE MISMO METODO
		} catch (SQLException e) {
			
			e.printStackTrace(System.out);
		}
		finally {
			
			try {
				close(stmt);
				close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}	
		}
		
		return registros;
	}
	
public int actualizar(Persona persona) {
	int registros = 0;
	Connection con = null;
	PreparedStatement  stmt = null;
	

	try {
		con = getConexion();
		stmt = con.prepareStatement(SQL_UPDATE);
		
		stmt.setString(1, persona.getNombre());
		stmt.setString(2, persona.getApellido());
		stmt.setString(3, persona.getEmail());
		stmt.setString(4, persona.getTelefono());
		stmt.setInt(5, persona.getIdPersona());
		registros = stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(System.out);
	}finally {		

		try {
			close(stmt);
			close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
	}
	
	return registros;
}	
	

public void eliminar(int id) {
	int registros = 0;
	Connection con = null;
	PreparedStatement  stmt = null;
	
	try {
		con = getConexion();
		stmt = con.prepareStatement(SQL_DELETE);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		
		try {
			close(stmt);
			close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}	

	
	
}
