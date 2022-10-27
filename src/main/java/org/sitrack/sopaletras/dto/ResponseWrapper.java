package org.sitrack.sopaletras.dto;

import java.io.Serializable;

public class ResponseWrapper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501740939980109374L;

	private String message;

	private int statusCode;

	private Object payload;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResponseWrapper [message=" + message + ", statusCode=" + statusCode + ", payload=" + payload + "]";
	}

}
