package manejoTransacciones;
import java.util.*;

import static manejoTransacciones.Conexion.*;

import java.sql.*;
public class PersonaDAO {

	private Connection conexionTransaccional;
	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre = ? ,apellido = ?, email = ? , telefono = ? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
	
	
	//UPDATE persona SET nombre = "Thiago", apellido = "Nuevo", email = "TNuevo@gmail.com", telefono = "12121" WHERE id_persona = 6;
	public PersonaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PersonaDAO(Connection conTransaccional) {
		
		this.conexionTransaccional = conTransaccional;
		
	}


	
	public List<Persona> seleccionar() throws SQLException{
		
		Connection con = null;
		PreparedStatement stm = null;
		
		ResultSet rs = null;
		
		Persona persona = null;
		
		List<Persona> personas = new ArrayList<> ();
	
		try {

			con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();	//si Conexion transaccional es distinto de nulo entonces lo usamos,
			//de lo contrario obtenemos una nueva conexion
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
	
	
	public int insertar(Persona p) throws SQLException {
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
	
public int actualizar(Persona persona) throws SQLException {
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
	

public void eliminar(int id) throws SQLException {
	int registros = 0;
	Connection con = null;
	PreparedStatement  stmt = null;
	
	try {
		con = getConexion();
		stmt = con.prepareStatement(SQL_DELETE);
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
	
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
