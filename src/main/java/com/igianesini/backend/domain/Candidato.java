package com.igianesini.backend.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Candidato() {
		
	}
	
	public Candidato(String nome, String cpf, String rg, Date data_nasc, String sexo, String mae, String pai,
			String email, String cep, String endereco, Integer numero, String bairro, String cidade, String estado,
			String telefone_fixo, String celular, Double altura, Integer peso, String tipo_sanguineo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
		this.mae = mae;
		this.pai = pai;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone_fixo = telefone_fixo;
		this.celular = celular;
		this.altura = altura;
		this.peso = peso;
		this.tipo_sanguineo = tipo_sanguineo;
		this.imc = calculaImc();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String cpf;
	private String rg;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data_nasc;
	
	private String sexo;
	private String mae;
	private String pai;
	private String email;
	private String cep;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone_fixo;
	private String celular;
	private Double altura;
	private Integer peso;
	private String tipo_sanguineo;
	private Integer imc;
	private Integer idade;
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer calculaImc() {
		/*DecimalFormat df = new DecimalFormat("###");
		Integer imcCalculado = Integer.parseInt(df.format(getPeso() / (getAltura() * getAltura())));*/
		
		Double calc = getPeso() / (getAltura() * getAltura());
		Integer imcCalculado = (int) (Math.round(calc * 100.0)/100.0);
		
		/*System.out.println(imcCalculado);*/
		return imcCalculado;
	}
	
	public Integer calculaIdade() {
		LocalDate dataNasc = getData_nasc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate hoje = LocalDate.now();
		return Period.between(dataNasc, hoje).getYears();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}
	public void setTipo_sanguineo(String tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}

	public Integer getImc() {
		return imc;
	}

	public void setImc(Integer imc) {
		this.imc = imc;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", data_nasc=" + data_nasc
				+ ", sexo=" + sexo + ", mae=" + mae + ", pai=" + pai + ", email=" + email + ", cep=" + cep
				+ ", endereco=" + endereco + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + ", telefone_fixo=" + telefone_fixo + ", celular=" + celular + ", altura="
				+ altura + ", peso=" + peso + ", tipo_sanguineo=" + tipo_sanguineo + ", imc=" + imc + ", idade=" + idade
				+ "]";
	}

}
