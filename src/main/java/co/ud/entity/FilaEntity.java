package co.ud.entity;

import java.util.ArrayList;
import java.util.List;

public class FilaEntity {

	private Long numeroFila;
	private List<SillaEntity> sillas;

	public static FilaEntity of() {
		FilaEntity filas = new FilaEntity();
		filas.setSillas(new ArrayList<>());
		filas.setNumeroFila(Long.valueOf("0"));
		filas.defaultSillas();
		return filas;
	}
	/**
	 * Metodo con el cual inicializo las sillas de cada fila 
	 */
	private void defaultSillas() {
		for(int i = 0; i < 20 ; i++) {
			SillaEntity silla = SillaEntity.of();
			silla.setNumerSilla(Long.valueOf(i));
			getSillas().add(silla);
		}
	}

	public Long getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(Long numeroFila) {
		this.numeroFila = numeroFila;
	}

	public List<SillaEntity> getSillas() {
		return sillas;
	}

	public void setSillas(List<SillaEntity> sillas) {
		this.sillas = sillas;
	}

}
