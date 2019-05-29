package co.ud.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import co.ud.ejb.IMapaCineEjb;
import co.ud.entity.SalaCineEntity;
import co.ud.entity.UsuarioEntity;

@Named
@SessionScoped
public class InicioMB extends BaseMB implements Serializable {

	private final static Logger log = Logger.getLogger(InicioMB.class.getName());
	private static final long serialVersionUID = 1L;

	@Inject
	IMapaCineEjb mapaCineEjb;

	private UsuarioEntity usuario;
	private SalaCineEntity cine;
	private String cliente;
	private Integer asientos;

	@PostConstruct
	public void init() {
		obtenerSesion();
		setAsientos(Integer.valueOf("1"));
		setCine(mapaCineEjb.obtieneSala());
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public SalaCineEntity getCine() {
		return cine;
	}

	public void setCine(SalaCineEntity cine) {
		this.cine = cine;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	/**
	 * Metodo con el cual obtengo la sala de cine
	 */
	public void refreshSala() {
		log.info(".:: Refrescar Sala cine ::.");
		setCine(mapaCineEjb.obtieneSala());
	}

	/**
	 * Metodo con el cual cambio el estado de la silla
	 */
	public void cambiarEstado(Long idFila, Long idSilla, String estado) {
		log.info("Valor recolectados fila: ".concat(idFila.toString()).concat(" Silla: ").concat(idSilla.toString())
				.concat(" Estado: ").concat(estado));
		mapaCineEjb.cambiaEstadoSilla(idFila, idSilla, getCliente(), getUsuario().getUser(), getAsientos());
	}
}
