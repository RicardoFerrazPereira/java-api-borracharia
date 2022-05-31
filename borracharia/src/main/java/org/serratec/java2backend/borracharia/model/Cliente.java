package org.serratec.java2backend.borracharia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome")
	private String nomeCliente;
	
	@Column(name="cliente_tx_cpf")
	private String cpf;
	
	@Column(name="cliente_tx_telefone")
	private String numTel;
	
	@Column(name="cliente_tx_email")
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Carro> listaCarro;
	
	
	public Cliente() {}

	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public List<Carro> getListaCarro() {
		return listaCarro;
	}


	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}
	
	
}
