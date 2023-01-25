package ejemplo4;

import java.sql.*;
import java.util.*;
public class EjemploMain2 {

	private Connection conexion = null;
	
	public EjemploMain2() throws SQLException 
	{
		  
		try {
			
			
			conectar();
			
		
			
			consulta("Broder");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			cerrar();
		}
		
		
	}
	
	public void conectar() throws SQLException {
		
		String jdbc = "jdbc:mysql://localhost:3307/ejemplo";
		conexion = DriverManager.getConnection(jdbc,"root", "root");
		
	}
	
public void cerrar() throws SQLException{
	
	if (conexion !=null) {
		conexion.close();
	}
	
	
}	
	


private void consulta(String apellido) throws SQLException {
	

	String query = "SELECT id_alumno, nombre,apellidos from alumnos where apellidos = ?";
	
	
	PreparedStatement pstmt = conexion.prepareStatement(query);
	
	pstmt.setString(1, apellido);
	
	
	ResultSet rs =pstmt.executeQuery();
	
	while(rs.next()) {
	
	int idAlumno = rs.getInt("id_alumno");
	String nombre = rs.getString("nombre");
	String apellidos = rs.getString("apellidos");
	
		
	System.out.println("Alumno: "+idAlumno+" Nombre: "+nombre+" apellidos: "+apellidos);	 
	
	}
	rs.close();
	pstmt.close();
}



//private static final Logger LOG = LoggerFactory.getLogget(EjemploMain.class);

public static void main(String args[]) {
	
	
	
	try {
	new EjemploMain2();
	}
	catch(SQLException e) {
		
		e.printStackTrace();
	}
	
	
}





}