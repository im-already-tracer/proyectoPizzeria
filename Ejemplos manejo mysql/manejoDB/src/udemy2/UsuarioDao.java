package udemy2;
import java.sql.*;

import static manejoTransacciones.Conexion.close;
import static udemy2.Conexion.*;
import static udemy2.Usuario.*;
import java.util.*;
public class UsuarioDao {
	
	private static final String SQL_SELECT ="SELECT * FROM usuario";
	
	private static final String SQL_INSERT ="INSERT INTO usuario(nom_usuario,password) VALUES (?,?)";
	
	private static final String SQL_UPDATE = "UPDATE usuario SET nom_usuario = ?, password = ? WHERE id_usuario = ?";
	
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
	
	
	public List <Usuario> seleccionar() {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario = null;
		
		
		try {
			con =  getConexion();
			stmt = con.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				int id =rs.getInt("id_usuario");
				String user = rs.getString("nom_usuario");
				String pass = rs.getString("password");
			
				
				usuario = new Usuario(id,user,pass);
				usuarios.add(usuario);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}finally {
			
			try {
				close(rs);
				close(stmt);
				close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
		
		return usuarios;
		
	}
	

public int insertar(Usuario us) {
	
	Connection con = null;
	PreparedStatement stmt = null;
	int registros = 0;
	
	try {
		con = getConexion();
		stmt = con.prepareStatement(SQL_INSERT);
		
		stmt.setString(1, us.getUsuario());
		stmt.setString(2, us.getPass());
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
			e.printStackTrace();
		}	
		
	}
	
	return registros;
}	
	
public int actualizar(Usuario us) {
	
	int registros = 0;
	
	Connection con = null;
	PreparedStatement stmt = null;
	
	
	try {
		con = getConexion();
		stmt = con.prepareStatement(SQL_UPDATE);
		stmt.setString(1, us.getUsuario());
		stmt.setString(2, us.getPass());
		stmt.setInt(3, us.getIdPersona());
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
			e.printStackTrace();
		}
		
		
	}
	
	return registros;
}	
	
	
	
public int eliminar (int id) {
	
	Connection con = null;
	PreparedStatement stmt = null;
	int registros = 0;
	
	
	try {
		con = getConexion();
		stmt = con.prepareStatement(SQL_DELETE);
		
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
finally {
		
		try {
			close(stmt);
			close(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

	
return registros;
}
}
