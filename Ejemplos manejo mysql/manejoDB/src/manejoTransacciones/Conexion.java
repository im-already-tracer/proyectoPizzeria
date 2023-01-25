package manejoTransacciones;
import java.sql.*;

public class Conexion {


private static final String JDBC_URL = "jdbc:mysql://localhost:3307/test? useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=True";



private static final String JDBC_USER = "root";

private static final String JDBC_PASSWORD = "root";		
		

public static Connection getConexion() throws SQLException {
	
return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
	
}



public static void close(ResultSet rs) throws SQLException{
	
	rs.close();
}

public static void close(Statement stmt) throws SQLException{
	
	stmt.close();
}
//prepare statement tiene una mejor performance que statement


public static void close(PreparedStatement stmt) throws SQLException{
	
	stmt.close();
}
public static void close(Connection con) throws SQLException{
	
	con.close();
}




}
