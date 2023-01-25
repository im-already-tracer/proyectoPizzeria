package ejemplo4;

import java.sql.*;

public class EjemploMain {

	private Connection conexion = null;
	
	public EjemploMain() throws SQLException 
	{
		try {
			
			
			conectar();
			consulta();
			
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
	


private void consulta() throws SQLException {
	
	Statement stmt = conexion.createStatement();
	
	//ResultSet rs =stmt.executeQuery("select id_alumno,nombre,apellidos from alumnos");
	
	//String query1 = "SELECT * from alumnos where apellidos = 'godoy'";
	String query1 = "SELECT id_alumno, nombre,apellidos from alumnos where apellidos = 'godoy'";
	ResultSet rs =stmt.executeQuery(query1);
	
	while(rs.next()) {
	
	int idAlumno = rs.getInt("id_alumno");
	String nombre = rs.getString("nombre");
	String apellidos = rs.getString("apellidos");
	
		
	System.out.println("Alumno: "+idAlumno+" Nombre: "+nombre+" apellidos: "+apellidos);	 //podria meterlo en un array de objetos y quedaria nashe
	
	}
	rs.close();
	stmt.close();
}



//private static final Logger LOG = LoggerFactory.getLogget(EjemploMain.class);

public static void main(String args[]) {
	
	try {
	new EjemploMain();
	}
	catch(SQLException e) {
		
		e.printStackTrace();
	}
	
	
}





}