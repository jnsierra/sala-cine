package co.ud.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import co.ud.entity.UsuarioEntity;

public abstract class BaseMB {

	public abstract void setUsuario(UsuarioEntity usuario);
	
	public void sendMessage(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", mensaje));
	}
	/**
	 * Metodo con el cual recupero el usuario de sesion y en el caso de que sea nulo lo instancia vacio
	 */
	public void obtenerSesion() {
		UsuarioEntity usuario = (UsuarioEntity) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("dataSession");
		if(usuario == null) {
			setUsuario(UsuarioEntity.of());
		}else {
			setUsuario(usuario);
		}
	}

}
