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
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7501740939980109374L;

	private String message;

	private int statusCode;

	private Object payload;

	
	
}
