package org.sitrack.sopaletras.exception;


import java.util.Date;


public class ErrorResponse {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String code;
    private Object error;
    private String path;

    public ErrorResponse(int statusCode, Date timestamp, String message, String code, String path) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.code = code;
        this.path = path;
    }

    public ErrorResponse(int statusCode, Date timestamp, String message, String code, Object error, String path) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.code = code;
        this.error = error;
        this.path = path;
    }

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", timestamp=" + timestamp + ", message=" + message
				+ ", code=" + code + ", error=" + error + ", path=" + path + "]";
	}
    
    
}