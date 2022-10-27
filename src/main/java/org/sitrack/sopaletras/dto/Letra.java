package org.sitrack.sopaletras.dto;

public class Letra {
	private String letra;
	private int estado;
	private int encontrada;
	
	

	public Letra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getEncontrada() {
		return encontrada;
	}

	public void setEncontrada(int encontrada) {
		this.encontrada = encontrada;
	}

	@Override
	public String toString() {
		return "Letra [letra=" + letra + ", estado=" + estado + ", encontrada=" + encontrada + "]";
	}

}
