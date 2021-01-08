package com.igianesini.backend;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igianesini.backend.dto.ResponseDTO;
import com.igianesini.backend.repositories.CandidatoRepository;
import com.igianesini.backend.services.CandidatoService;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {
	
	@Autowired
	private CandidatoRepository repo;
	@Autowired
	private CandidatoService service;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
				
		/* if(repo.findAll().size() == 0) {
			service.initializeDB();
		} */
    }
}
