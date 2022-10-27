package org.sitrack.sopaletras.dto;

import java.io.Serializable;
import java.util.List;

public class ResponsePalabras implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7521121779943979575L;
	
	private List<String> palabras;
	
	

	public ResponsePalabras() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<String> palabras) {
		this.palabras = palabras;
	}

	@Override
	public String toString() {
		return "ResponsePalabras [palabras=" + palabras + "]";
	}

}
