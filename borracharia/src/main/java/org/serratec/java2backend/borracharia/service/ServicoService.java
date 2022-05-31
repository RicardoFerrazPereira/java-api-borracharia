package org.serratec.java2backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.java2backend.borracharia.dto.RelatorioDTO;
import org.serratec.java2backend.borracharia.dto.ServicoDTO;
import org.serratec.java2backend.borracharia.exception.EmailException;
import org.serratec.java2backend.borracharia.exception.ServicoException;
import org.serratec.java2backend.borracharia.model.Servico;
import org.serratec.java2backend.borracharia.repository.CarroRepository;
import org.serratec.java2backend.borracharia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;
	
	

	public Servico dtoModel(ServicoDTO servicoDTO, Servico servico) {

		servico.setValorServ(servicoDTO.getValorServ());
		servico.setTipoServ(servicoDTO.getTipoServ());
		servico.setDataServ(servicoDTO.getDataServ());
		
		if(servicoDTO.getIdCarro() != null) {
			servico.setCarro(carroRepository.findById(servicoDTO.getIdCarro()).get());
		}

		return servico;
	}

	public ServicoDTO modelDto(Servico servico, ServicoDTO servicoDTO) {

		servicoDTO.setIdServico(servico.getIdServico());
		servicoDTO.setValorServ(servico.getValorServ());
		servicoDTO.setTipoServ(servico.getTipoServ());
		servicoDTO.setDataServ(servico.getDataServ());
		servicoDTO.setIdCarro(servico.getCarro().getIdCarro());

		return servicoDTO;
	}

	public String salvar(ServicoDTO servicoDTO) throws MessagingException, EmailException {
		Servico servico = new Servico();
		dtoModel(servicoDTO, servico);
		servicoRepository.save(servico);
		emailService.emailTeste(servicoDTO);
		
		return "Serviço salvo";
	}

	public List<ServicoDTO> listarTodos() {
		List<Servico> listaServicos = servicoRepository.findAll();
		List<ServicoDTO> listaServicosDto = new ArrayList<>();

		for (Servico servico : listaServicos) {
			ServicoDTO servicoDTO = new ServicoDTO();
			modelDto(servico, servicoDTO);
			listaServicosDto.add(servicoDTO);
		}
		return listaServicosDto;
	}

	public ServicoDTO buscarPorId(Integer idServico) throws ServicoException {
		Optional<Servico> servico = servicoRepository.findById(idServico);
		Servico servicoModel = new Servico();
		ServicoDTO servicoDTO = new ServicoDTO();
		if(servico.isPresent()) {
			servicoModel = servico.get();
			modelDto(servicoModel, servicoDTO);
			return servicoDTO;
		}
		throw new ServicoException("##  Serviço não encontrado com o ID informado!  ##");

	}

	public String deletarPorId(Integer idServico) {
		servicoRepository.deleteById(idServico);
		return "### Serviço excluído com sucesso ###";
	}

	public String atualizarPorId(Integer idServico, ServicoDTO servicoDTO) throws ServicoException {
		Optional<Servico> servico = servicoRepository.findById(idServico);
		Servico servicoModel = new Servico();
		if(servico.isPresent()) {
			servicoModel = servico.get();
			if(servicoDTO.getValorServ() != null) {
				servicoModel.setValorServ(servicoDTO.getValorServ());
			}
			if(servicoDTO.getTipoServ() != null) {
				servicoModel.setTipoServ(servicoDTO.getTipoServ());
			}
			if(servicoDTO.getDataServ() != null) {
				servicoModel.setDataServ(servicoDTO.getDataServ());
			}
			servicoRepository.save(servicoModel);
			return "###  Serviço Atualizado  ###";
		}
		throw new ServicoException("###  Serviço não foi Atualizado  ###");
		
	}
	
	public String salvarMuitos(List<ServicoDTO> listaServicoDTO) {
		List<Servico> listaServicoModel = new ArrayList<>();
		for (ServicoDTO servicoDTO : listaServicoDTO) {
			Servico servico = new Servico();
			dtoModel(servicoDTO, servico);
			listaServicoModel.add(servico);
		}
		servicoRepository.saveAll(listaServicoModel);
		return "##  Serviços cadastrados com sucesso!  ##";
		
	}
	
	public List<RelatorioDTO> relatorio() {
		return servicoRepository.relatorio();
	}
	
	
	
	

}