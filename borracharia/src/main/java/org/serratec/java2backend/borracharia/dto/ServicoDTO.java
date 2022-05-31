package org.serratec.java2backend.borracharia.dto;

import java.io.Serializable;
import java.util.Date;

public class ServicoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idServico;
	private Double valorServ;
	private String tipoServ;
	private Date dataServ;
	private Integer idCarro;
	
	public ServicoDTO() {}
	
	
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

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	
	
	
}
