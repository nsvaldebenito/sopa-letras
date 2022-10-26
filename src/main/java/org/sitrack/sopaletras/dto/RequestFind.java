package org.sitrack.sopaletras.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@NoArgsConstructor
@AllArgsConstructor
public class RequestFind implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3064517718344039658L;

	@NotNull private int sr;

	@NotNull private int sc;

	@NotNull private int er;

	@NotNull private int ec;
	
	/*public RequestFind(int sr,int sc,int er,int ec) {
	    this.sr = sr;
	    this.sc = sc;
	    this.er = er;
	    this.ec = ec;
	   
	}*/

}
