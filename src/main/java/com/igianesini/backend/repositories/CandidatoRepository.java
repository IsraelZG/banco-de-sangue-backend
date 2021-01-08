package com.igianesini.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.igianesini.backend.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj.estado FROM Candidato obj")
	List<String> findDistinctEstados();
	
	/*@Transactional(readOnly=true)
	@Query("SELECT COUNT(obj) FROM Candidato obj WHERE obj.estado = :estado")
	Integer countCandidatosporEstado(@Param("estado") String estado);*/
	
	@Transactional(readOnly=true)
	List<Candidato> findByEstado(String estado);
	
	@Transactional(readOnly=true)
	Candidato findTopByOrderByIdadeDesc();
	
	/*@Transactional(readOnly=true)
	@Query("SELECT obj FROM Candidato obj where obj.idade >= :min and obj.idade <= :max")
	List<Candidato> findCandidatosPorIdade(@Param("min") Integer min, @Param("max") Integer max);*/
	
	@Transactional(readOnly=true)
	List<Candidato> findByIdadeBetween(Integer min,Integer max);
	
	@Transactional(readOnly=true)
	List<Candidato> findBySexo(String sexo);
	
	@Transactional(readOnly=true)
	List<Candidato> findBySexoAndImcGreaterThan(String sexo, Integer imc);
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj.tipo_sanguineo FROM Candidato obj")
	List<String> findDistinctTipoSanguineo();
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Candidato obj WHERE obj.tipo_sanguineo = :tipo AND obj.idade >= 16 AND obj.idade <= 69 AND obj.peso > 50")
	List<Candidato> findByTipoSanguineo(@Param("tipo") String tipoSanguineo);
	
	@Transactional(readOnly=true)
	List<Candidato> findByCpf(String cpf);
	
}
