package org.sitrack.sopaletras.dto;

import java.util.List;

public class Soup {
	private List<Rows> rows;
	private List<PosicionAletaoria> palabras;
	public List<Rows> getRows() {
		return rows;
	}
	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}
	public List<PosicionAletaoria> getPalabras() {
		return palabras;
	}
	public void setPalabras(List<PosicionAletaoria> palabras) {
		this.palabras = palabras;
	}
	@Override
	public String toString() {
		return "Soup [rows=" + rows + ", palabras=" + palabras + "]";
	}
	

}
