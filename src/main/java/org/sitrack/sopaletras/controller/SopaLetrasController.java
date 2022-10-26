package org.sitrack.sopaletras.controller;

import java.text.ParseException;
import java.util.UUID;

import javax.validation.Valid;

import org.sitrack.sopaletras.dto.RequestFind;
import org.sitrack.sopaletras.dto.RequestSoup;
import org.sitrack.sopaletras.dto.ResponseWrapper;
import org.sitrack.sopaletras.service.SopaLetrasService;
import org.sitrack.sopaletras.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * SopaLetrasController Class
 *
 * @author nsvaldebenito@gmail.com
 */

@RestController
@CrossOrigin(origins = { "*" })
public class SopaLetrasController {

	@Autowired
	SopaLetrasService sopaLetrasService;

	@PostMapping(path = "/", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper> addSoup(@Valid @RequestBody RequestSoup requestSoup) throws Exception {

		ResponseWrapper response = Utils.formatResponse(HttpStatus.CREATED.value(),
				HttpStatus.CREATED.getReasonPhrase(), sopaLetrasService.addSoup(requestSoup));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping(path = "/list/{soupId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper> soupListById(@PathVariable(value = "soupId") UUID soupId) {

		ResponseWrapper response = Utils.formatResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),
				sopaLetrasService.listSoup(soupId));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/view/{soupId}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public String soupViewById(@PathVariable(value = "soupId") UUID soupId) {

     	return sopaLetrasService.viewSoup(soupId);
	}

	@PutMapping(path = { "/{soupId}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseWrapper> updateStatusSopa(@PathVariable(value = "soupId")  UUID soupId,
			@Valid @RequestBody RequestFind requestFind) throws ParseException {

		ResponseWrapper response = Utils.formatResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),
				sopaLetrasService.updateSoup(soupId, requestFind));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/health", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String health() {

		return "Service available";
	}
}
