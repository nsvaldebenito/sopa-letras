package org.sitrack.sopaletras.dto;

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
public class PosicionAletaoria {
	
	private int sr;
	private int sc;
	private int er;
	private int ec;
	private String palabra;
	private String direccion;
	private int length;
	private int estado;

}
