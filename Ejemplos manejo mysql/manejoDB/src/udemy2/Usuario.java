package udemy2;

public class Usuario {

	private int idPersona;
	private String usuario;
	private String pass;
	
	
	public Usuario(String usuario, String pass) {
	
		this.usuario = usuario;
		this.pass = pass;
	}
	
	
	public Usuario(int id,String usuario, String pass) {
		this.idPersona = id;
		this.usuario = usuario;
		this.pass = pass;
	}
	
	
	
	
	public Usuario() {}
	
	public Usuario(int id) {
		
		this.idPersona = id;
		
	}
	
	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Usuario [idPersona=" + idPersona + ", usuario=" + usuario + ", pass=" + pass + "]";
	}
	
	
}
