package org.sitrack.sopaletras.dto;


public class Palabra {
	private String palabra;
	private int iniPosX;
	private int iniPosY;
	private int finPosX;
	private int finPosY;
	private int direccion;
	
	
	
	public Palabra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public int getIniPosX() {
		return iniPosX;
	}
	public void setIniPosX(int iniPosX) {
		this.iniPosX = iniPosX;
	}
	public int getIniPosY() {
		return iniPosY;
	}
	public void setIniPosY(int iniPosY) {
		this.iniPosY = iniPosY;
	}
	public int getFinPosX() {
		return finPosX;
	}
	public void setFinPosX(int finPosX) {
		this.finPosX = finPosX;
	}
	public int getFinPosY() {
		return finPosY;
	}
	public void setFinPosY(int finPosY) {
		this.finPosY = finPosY;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", iniPosX=" + iniPosX + ", iniPosY=" + iniPosY + ", finPosX=" + finPosX
				+ ", finPosY=" + finPosY + ", direccion=" + direccion + "]";
	}
	
	

}
