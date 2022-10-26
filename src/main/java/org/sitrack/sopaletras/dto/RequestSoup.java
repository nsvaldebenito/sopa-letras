package org.sitrack.sopaletras.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
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

}
