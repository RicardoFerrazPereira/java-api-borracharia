package org.serratec.java2backend.borracharia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="carro_cd_id")
	private Integer idCarro;
	
	@Column(name="carro_tx_modelo")
	private String modelo;
	
	@Column(name="carro_tx_marca")
	private String marca;
	
	@Column(name="carro_num_ano")
	private Integer ano;
	
	@JsonIgnore
	@OneToMany(mappedBy = "carro")
	private List<Servico> listaServico;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName = "cliente_cd_id")
	private Cliente cliente;
	
	public Carro() {}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getListaServico() {
		return listaServico;
	}

	public void setListaServico(List<Servico> listaServico) {
		this.listaServico = listaServico;
	}
	

	
	
	
}
