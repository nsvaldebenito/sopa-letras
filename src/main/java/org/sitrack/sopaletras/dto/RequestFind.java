package org.sitrack.sopaletras.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class RequestFind implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3064517718344039658L;

	@NotNull
	private int sr;

	@NotNull
	private int sc;

	@NotNull
	private int er;

	@NotNull
	private int ec;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RequestFind [sr=" + sr + ", sc=" + sc + ", er=" + er + ", ec=" + ec + "]";
	}

}
