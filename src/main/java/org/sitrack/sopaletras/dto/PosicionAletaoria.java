package org.sitrack.sopaletras.dto;

public class PosicionAletaoria {

	private int sr;
	private int sc;
	private int er;
	private int ec;
	private String palabra;
	private String direccion;
	private int length;
	private int estado;

	public int getSr() {
		return sr;
	}

	public void setSr(int sr) {
		this.sr = sr;
	}

	public int getSc() {
		return sc;
	}

	public void setSc(int sc) {
		this.sc = sc;
	}

	public int getEr() {
		return er;
	}

	public void setEr(int er) {
		this.er = er;
	}

	public int getEc() {
		return ec;
	}

	public void setEc(int ec) {
		this.ec = ec;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "PosicionAletaoria [sr=" + sr + ", sc=" + sc + ", er=" + er + ", ec=" + ec + ", palabra=" + palabra
				+ ", direccion=" + direccion + ", length=" + length + ", estado=" + estado + "]";
	}

}
