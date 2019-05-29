package co.ud.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import co.ud.entity.UsuarioEntity;

@Named
@RequestScoped
public class LoginMB extends BaseMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioEntity usuario;

	private final static Logger log = Logger.getLogger(LoginMB.class.getName());

	@PostConstruct
	public void init() {
		obtenerSesion();
		log.info(".:: Inicia el login de la aplicacion::.");
	}

	/**
	 * Metodo desde el cual se realiza el login a la aplicación
	 */
	public String login() {
		log.info("Intento de login usuario: ".concat(getUsuario().getUser()));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dataSession", getUsuario());
		return "inicio.jsf";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index.jsf";
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

}
