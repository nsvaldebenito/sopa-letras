package org.sitrack.sopaletras.dto;

import java.io.Serializable;

public class RequestSoup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5090379911712114377L;

	private int w;

	private int h;

	private boolean ltr;

	private boolean rtl;

	private boolean ttb;

	private boolean btt;

	private boolean d;

	public RequestSoup() {
		this.w = 15;
		this.h = 15;
		this.ltr = true;
		this.rtl = false;
		this.ttb = true;
		this.btt = false;
		this.d = false;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public boolean isLtr() {
		return ltr;
	}

	public void setLtr(boolean ltr) {
		this.ltr = ltr;
	}

	public boolean isRtl() {
		return rtl;
	}

	public void setRtl(boolean rtl) {
		this.rtl = rtl;
	}

	public boolean isTtb() {
		return ttb;
	}

	public void setTtb(boolean ttb) {
		this.ttb = ttb;
	}

	public boolean isBtt() {
		return btt;
	}

	public void setBtt(boolean btt) {
		this.btt = btt;
	}

	public boolean isD() {
		return d;
	}

	public void setD(boolean d) {
		this.d = d;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RequestSoup [w=" + w + ", h=" + h + ", ltr=" + ltr + ", rtl=" + rtl + ", ttb=" + ttb + ", btt=" + btt
				+ ", d=" + d + "]";
	}

}
