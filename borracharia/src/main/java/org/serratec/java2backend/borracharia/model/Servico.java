package org.serratec.java2backend.borracharia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="servico")
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="servico_cd_id")
	private Integer idServico;
	
	@Column(name="servico_num_valor")
	private Double valorServ;
	
	@Column(name="servico_tx_tipo")
	private String tipoServ;
	
	@Column(name="servico_dt_data")
	private Date dataServ;
	
	@ManyToOne
	@JoinColumn(name="carro_id", referencedColumnName = "carro_cd_id")
	@JsonIgnore
	private Carro carro;
	
	public Servico() {}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Double getValorServ() {
		return valorServ;
	}

	public void setValorServ(Double valorServ) {
		this.valorServ = valorServ;
	}

	public String getTipoServ() {
		return tipoServ;
	}

	public void setTipoServ(String tipoServ) {
		this.tipoServ = tipoServ;
	}

	public Date getDataServ() {
		return dataServ;
	}

	public void setDataServ(Date dataServ) {
		this.dataServ = dataServ;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
}
