package co.ud.entity;

import co.ud.enumeracion.ESTADO_UBICACION;

public class SillaEntity {

	private Long numerSilla;
	private ESTADO_UBICACION estado;
	private String cliente;
	private String usuarioRes;
	
	private SillaEntity(Long numerSilla, ESTADO_UBICACION estado, String cliente, String usuarioRes) {
		super();
		this.numerSilla = numerSilla;
		this.estado = estado;
		this.cliente = cliente;
		this.usuarioRes = usuarioRes;
	}

	public static SillaEntity of() {
		return new SillaEntity(Long.valueOf(0), ESTADO_UBICACION.VACIO, "", "");
	}

	public Long getNumerSilla() {
		return numerSilla;
	}

	public void setNumerSilla(Long numerSilla) {
		this.numerSilla = numerSilla;
	}

	public ESTADO_UBICACION getEstado() {
		return estado;
	}

	public void setEstado(ESTADO_UBICACION estado) {
		this.estado = estado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getUsuarioRes() {
		return usuarioRes;
	}

	public void setUsuarioRes(String usuarioRes) {
		this.usuarioRes = usuarioRes;
	}
	
	public String getInfoBasica() {
		return "Silla No. ".concat(getNumerSilla().toString()).concat(" Cliente: ").concat(getCliente()).concat(" Por el usuario: ").concat(getUsuarioRes());
	}

	
	
}
