package br.com.springboot.jemoliveira.demojemoliveira.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.jemoliveira.demojemoliveira.service.impl.GoogleMapsService;
import br.com.springboot.jemoliveira.demojemoliveira.service.impl.JemoliveiraService;
import br.com.springboot.jemoliveira.demojemoliveira.service.impl.ReadJsonService;

@RestController
public class JemoliveiraController {

	@Autowired
	private JemoliveiraService jemoliveiraService;

	@Autowired
	private GoogleMapsService googleMapsService;
	
	@Autowired
	private ReadJsonService readJsonService;

	@RequestMapping("/showMessage") 
	public @ResponseBody ResponseEntity<?> showMessage() {
		return new ResponseEntity<>(jemoliveiraService.showMessage(), HttpStatus.OK);
	}

	@RequestMapping(value = "/insertMessage", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> insertMessage(@RequestBody String text) {
		return new ResponseEntity<>(jemoliveiraService.insertMessage(text), HttpStatus.OK);
	}

	@RequestMapping(path = "getGoogleMapsInfo/{latitude}/{longitude}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getGoogleMapsInfo(
			@PathVariable(name = "latitude")
			final double latitude,
			@PathVariable(name = "longitude")
			final double longitude) {

		return new ResponseEntity<>(googleMapsService.getInfosGoogleMap(latitude, longitude), HttpStatus.OK);
	}
	
	@RequestMapping(path = "readJson/{sigla}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> readJson(@PathVariable(name = "sigla") final String sigla) {		
		return new ResponseEntity<>(readJsonService.read(sigla), HttpStatus.OK);
	}
}