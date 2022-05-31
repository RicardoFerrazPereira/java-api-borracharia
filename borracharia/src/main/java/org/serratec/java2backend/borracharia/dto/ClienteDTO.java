package org.serratec.java2backend.borracharia.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private String nomeCliente;
	private String cpf;
	private String numTel;
	private String email;
	
	public ClienteDTO() {}

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
	
	

}
