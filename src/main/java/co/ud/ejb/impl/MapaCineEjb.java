package co.ud.ejb.impl;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import co.ud.ejb.IMapaCineEjb;
import co.ud.entity.SalaCineEntity;
import co.ud.enumeracion.ESTADO_UBICACION;

@Singleton
@Startup
public class MapaCineEjb implements IMapaCineEjb{

	private SalaCineEntity sala;
	private final static Logger log = Logger.getLogger(MapaCineEjb.class.getName());
	
	@PostConstruct
	public void init() {
		log.info(".::  Se inicializa el objeto sala de cine ::.");
		sala = SalaCineEntity.of();
	}

	@Override
	public SalaCineEntity obtieneSala() {
		return sala;
	}
	/**
	 * Metodo con el cual cambio de estado la silla
	 * @param fila
	 * @param silla
	 */
	@Lock(LockType.WRITE)
	public void cambiaEstadoSilla(Long fila, Long silla, String cliente, String usuario) {
		ESTADO_UBICACION estadoActual = sala.getFilas().get(fila.intValue()).getSillas().get(silla.intValue()).getEstado();
		sala.getFilas().get(fila.intValue()).getSillas().get(silla.intValue()).setCliente(cliente);
		sala.getFilas().get(fila.intValue()).getSillas().get(silla.intValue()).setUsuarioRes(usuario);
		if(estadoActual.equals(ESTADO_UBICACION.VACIO)) {
			sala.getFilas().get(fila.intValue()).getSillas().get(silla.intValue()).setEstado(ESTADO_UBICACION.OCUPADO);
		}else if(estadoActual.equals(ESTADO_UBICACION.OCUPADO)) {
			sala.getFilas().get(fila.intValue()).getSillas().get(silla.intValue()).setEstado(ESTADO_UBICACION.RESERVADO);
		}else if(estadoActual.equals(ESTADO_UBICACION.RESERVADO)) {
			sala.getFilas().get(fila.intValue()).getSillas().get(silla.intValue()).setEstado(ESTADO_UBICACION.VACIO);
		}
	}
}
