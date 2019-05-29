package co.ud.ejb;

import javax.ejb.Local;

import co.ud.entity.SalaCineEntity;

@Local
public interface IMapaCineEjb {
	/**
	 * Metodo con el cual obtengo la sala de cine
	 * @return
	 */
	SalaCineEntity obtieneSala();
	/**
	 * Metodo con el cual cambio el estado de una silla
	 * @param fila
	 * @param silla
	 */
	void cambiaEstadoSilla(Long fila, Long silla, String cliente, String usuario, Integer asientos);
	
	
}
