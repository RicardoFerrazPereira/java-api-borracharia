package org.serratec.java2backend.borracharia.dto;

import java.io.Serializable;

public class CarroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idCarro;
	private String modelo;
	private String marca;
	private Integer ano;
	private Integer idCliente;
			
	public CarroDTO() {}
	
	
	public Integer getIdCarro() {
		return idCarro;
	}
	
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
    
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	

		
}
