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
public class Palabra {
	private String palabra;
	private int iniPosX;
	private int iniPosY;
	private int finPosX;
	private int finPosY;
	private int direccion;

}
