package com.igianesini.backend.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.igianesini.backend.dto.ResponseDTO;
import com.igianesini.backend.services.CandidatoService;

@CrossOrigin
@RestController
@RequestMapping(value="/")
public class CandidatoResource {
	
	@Autowired
	private CandidatoService service;
	
	@RequestMapping(value="/visualizar", method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO> enviarDados() throws JsonParseException, JsonMappingException, IOException {
		ResponseDTO response = new ResponseDTO(
				service.getCandidatosPorEstado(),
				service.getImcPorIdade(),
				service.getObesosPorSexo(),
				service.getIdadesPorTipoSanguineo(),
				service.getDoadoresPorReceptor());
		
		return ResponseEntity.ok().body(response);
	}
}
