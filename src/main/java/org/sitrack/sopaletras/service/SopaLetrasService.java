package org.sitrack.sopaletras.service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import org.sitrack.sopaletras.dto.RequestFind;
import org.sitrack.sopaletras.dto.RequestSoup;
import org.sitrack.sopaletras.dto.Soup;
import org.sitrack.sopaletras.model.SoupEntity;
import org.springframework.stereotype.Service;




public interface SopaLetrasService {
	
	SoupEntity addSoup(RequestSoup requestSoup) throws Exception;
		
	String updateSoup(
			   UUID soupId,
		      RequestFind requestFind) throws ParseException;
	
	String viewSoup(UUID soupId) ;
	
	List<String> listSoup(UUID soupId) ;

}
