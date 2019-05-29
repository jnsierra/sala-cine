package co.ud.entity;

public class UsuarioEntity {

	private String user;
	
	public static UsuarioEntity of() {
		return new UsuarioEntity();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
