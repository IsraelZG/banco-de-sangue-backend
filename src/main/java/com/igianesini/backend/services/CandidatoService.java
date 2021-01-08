package com.igianesini.backend.services;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.igianesini.backend.domain.Candidato;
import com.igianesini.backend.domain.TipoSanguineo;
import com.igianesini.backend.dto.DoadoresPorReceptorDTO;
import com.igianesini.backend.dto.EstadoDTO;
import com.igianesini.backend.dto.IMCPorIdadeDTO;
import com.igianesini.backend.dto.IdadePorTipoSanguineoDTO;
import com.igianesini.backend.dto.ObesosPorSexoDTO;
import com.igianesini.backend.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repo;
	
	public void initializeDBfromFileSystem() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    objectMapper.setDateFormat(df);
	    /*String response = "Nenhum registro inserido, por favor verifique";*/
	    
	    File data = new File("data.json");
	    
	    if(data.length() > 0) {
	    	Candidato[] candidatosArray = objectMapper.readValue(data, Candidato[].class);
		    
		    List<Candidato> candidatos = new ArrayList<Candidato>();
		    
		    for(Candidato candidato : candidatosArray) {
		    	if (repo.findByCpf(candidato.getCpf()).size() == 0) {
		    		candidato.setImc(candidato.calculaImc());
			    	candidato.setIdade(candidato.calculaIdade());
			    	candidatos.add(candidato);
		    	}
		    }
		    /*response = "Inseridos " + String.valueOf(repo.saveAll(candidatos).size()) + " registros no banco de dados";*/
	    }
	    /*return response;*/
	}
	
	public List<EstadoDTO> getCandidatosPorEstado( ) {
		List<EstadoDTO> candidatosPorEstado = new ArrayList<EstadoDTO>();
        List<String> estados = (List<String>) repo.findDistinctEstados();
        
        for(String estado : estados) {
        	EstadoDTO esteEstado = new EstadoDTO(estado, repo.findByEstado(estado).size()) ;
        	candidatosPorEstado.add(esteEstado);
        } 
        return candidatosPorEstado;
	}
	
	public List<IMCPorIdadeDTO> getImcPorIdade() {
		List<IMCPorIdadeDTO> imcPorIdade = new ArrayList<IMCPorIdadeDTO>();
        Integer maiorIdade = repo.findTopByOrderByIdadeDesc().getIdade();
        Integer min = 0;
        Integer max = 10;
        
        while (min < maiorIdade) {
    	   List<Candidato> candidatosNestaFaixa = repo.findByIdadeBetween(min, max);
    	   Integer imcTotal = 0;
    	   Integer imcMedio = 0;
    	   
    	   for(Candidato candidato : candidatosNestaFaixa) { 
    		   imcTotal = imcTotal + candidato.getImc();
    	   }
    	   
    	   if (candidatosNestaFaixa.size() > 0) {
    		   imcMedio = (int) Math.round(imcTotal / candidatosNestaFaixa.size());
    	   } else {
    		   imcMedio = 0;
    	   }
    	   
    	   imcPorIdade.add(new IMCPorIdadeDTO(min, max, imcMedio));
    	   
    	   min = max +1;
    	   max = max +10;
        }
        return imcPorIdade;
	}

	public List<ObesosPorSexoDTO> getObesosPorSexo() {
		Double masculinos = (double) repo.findBySexo("Masculino").size();
        Double masculinosObesos = (double) repo.findBySexoAndImcGreaterThan("Masculino", 30).size();
        Double femininos = (double) repo.findBySexo("Feminino").size();
        Double femininosObesos = (double) repo.findBySexoAndImcGreaterThan("Feminino", 30).size();
        
        Integer percentualMasculinosObesos = (int) Math.round((masculinosObesos / masculinos)*100);
        Integer percentualFemininosObesos = (int) Math.round((femininosObesos / femininos)*100); 
        List<ObesosPorSexoDTO> obesosPorSexo = new ArrayList<ObesosPorSexoDTO>();
        obesosPorSexo.add(new ObesosPorSexoDTO("Masculino", percentualMasculinosObesos));
        obesosPorSexo.add(new ObesosPorSexoDTO("Feminino", percentualFemininosObesos));
        return obesosPorSexo;
	}
	
	public List<IdadePorTipoSanguineoDTO> getIdadesPorTipoSanguineo() {
		List<String> tiposSanguineos = repo.findDistinctTipoSanguineo();
        List<IdadePorTipoSanguineoDTO> idadesPorTipoSanguineo = new ArrayList<IdadePorTipoSanguineoDTO>(); 
        
        for(String tipoSanguineo : tiposSanguineos) {
        	List<Candidato> desteTipoSanguineo = repo.findByTipoSanguineo(tipoSanguineo);
        	Integer idadeTotal = 0;
        	Integer idadeMedia = 0;
        	
        	for(Candidato candidato : desteTipoSanguineo) {
        		idadeTotal = idadeTotal + candidato.getIdade();
        	}
        	
        	idadeMedia = idadeTotal / desteTipoSanguineo.size();
        	IdadePorTipoSanguineoDTO esteTipoSanguineo = new IdadePorTipoSanguineoDTO(tipoSanguineo, idadeMedia);
        	idadesPorTipoSanguineo.add(esteTipoSanguineo);
        } 
        return idadesPorTipoSanguineo;
	}
	
	
	public List<DoadoresPorReceptorDTO> getDoadoresPorReceptor() throws JsonProcessingException{
		List<TipoSanguineo> tiposSanguineos = getTiposSanguineos();
		List<DoadoresPorReceptorDTO> doadoresPorReceptor = new ArrayList<DoadoresPorReceptorDTO>();
        
        for(TipoSanguineo tipo : tiposSanguineos) {
        	Integer doadoresTotal = 0;
        	
        	for(String tipoDoador : tipo.getRecebeDe()) {
        		doadoresTotal = doadoresTotal + repo.findByTipoSanguineo(tipoDoador).size();
        	}
        	
        	DoadoresPorReceptorDTO esteReceptor = new DoadoresPorReceptorDTO(tipo.getTipo(), doadoresTotal);
        	doadoresPorReceptor.add(esteReceptor);
        }
		return doadoresPorReceptor;
	}
	
	public List<TipoSanguineo> getTiposSanguineos() {
		List<TipoSanguineo> tiposSanguineos = new ArrayList<TipoSanguineo>();
		String[] tipos = {"A+", "A-","B+", "B-", "AB+", "AB-", "O+", "O-"};
		String[][] recebemDe = {
				{"A+","A-","O+","O-"},
				{"A-","O-"},
				{"B+","B-","O+","O-"},
				{"B-","O-"},
				{"A+","B+","O+","AB+","A-","B-","O-","AB-"},
				{"A-","B-","O-","AB-"},
				{"O+", "O-"},
				{"O-"}
		};
		for(int i = 0; i < tipos.length; ++i) {
			tiposSanguineos.add(new TipoSanguineo(tipos[i], recebemDe[i]));
		}
		return tiposSanguineos;
	}
}
