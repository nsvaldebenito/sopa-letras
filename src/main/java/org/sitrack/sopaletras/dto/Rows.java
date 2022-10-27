package org.sitrack.sopaletras.dto;

import java.util.List;


public class Rows {
	private List<Letra> letras;

	public List<Letra> getLetras() {
		return letras;
	}

	public void setLetras(List<Letra> letras) {
		this.letras = letras;
	}
	
	
	

	public Rows() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Rows [letras=" + letras + "]";
	}
	
	

}
