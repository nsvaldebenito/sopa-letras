package org.sitrack.sopaletras.model;

import org.sitrack.sopaletras.dto.Soup;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "soups")
public class SoapEntityExtend extends SoupEntity {

	private Soup soup;
	
	

	public SoapEntityExtend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Soup getSoup() {
		return soup;
	}

	public void setSoup(Soup soup) {
		this.soup = soup;
	}

	@Override
	public String toString() {
		return "SoapEntityExtend [soup=" + soup + "]";
	}

}
