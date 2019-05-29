package co.ud.entity;

import java.util.ArrayList;
import java.util.List;

public class SalaCineEntity {

	private String nombreSala;
	private List<FilaEntity> filas;
	
	public static SalaCineEntity of() {
		SalaCineEntity sala = new SalaCineEntity();
		sala.setFilas(new ArrayList<>());
		sala.defaultFilas();
		return sala;
	}
	/**
	 * Metodo con el cual incializo las filas de la sala
	 */
	private void defaultFilas() {
		for(int i = 0; i < 20 ; i++) {
			FilaEntity fila = FilaEntity.of();
			fila.setNumeroFila(Long.valueOf(i));
			getFilas().add(fila);
		}
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public List<FilaEntity> getFilas() {
		return filas;
	}

	public void setFilas(List<FilaEntity> filas) {
		this.filas = filas;
	}

}
