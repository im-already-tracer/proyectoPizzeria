package udemy;


import java.sql.*;

public class Test {

	/*
	public static void main(String [] args) {
		
		String url = "jdbc:mysql://localhost:3307/test? useSSL=false&useTimezone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=True";
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver"); esta linea no es requerida trabajando de manera local, pero en app webs si
			
			
			
			Connection con = DriverManager.getConnection(url,"root", "root");

			Statement instruccion = con.createStatement();
			String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
			ResultSet resultado = instruccion.executeQuery(sql);
			
			while(resultado.next()) {
				
				
				System.out.println("Id: "+resultado.getInt("id_persona"));
				System.out.println("nom: "+resultado.getString(2));
				System.out.println("ape: "+resultado.getString(3));
				System.out.println("email: "+resultado.getString(4));
				System.out.println("tel: "+resultado.getString(5));
				System.out.println();
			}
			
			resultado.close();
			instruccion.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
	}
	
	*/
}
