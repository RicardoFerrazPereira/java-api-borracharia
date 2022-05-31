package org.serratec.java2backend.borracharia.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.java2backend.borracharia.dto.RelatorioDTO;
import org.serratec.java2backend.borracharia.dto.ServicoDTO;
import org.serratec.java2backend.borracharia.exception.EmailException;
import org.serratec.java2backend.borracharia.exception.ServicoException;
import org.serratec.java2backend.borracharia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {
	
	@Autowired
	ServicoService servicoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvarServico(@RequestBody ServicoDTO servicoDTO) throws MessagingException, EmailException {
		return ResponseEntity.ok(servicoService.salvar(servicoDTO));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ServicoDTO>> listarTodos() {
		return ResponseEntity.ok(servicoService.listarTodos());
	}
	
	@GetMapping("/buscar/{idServico}")
	public ResponseEntity<ServicoDTO> servicoPorId(@PathVariable Integer idServico) throws ServicoException {
		return ResponseEntity.ok(servicoService.buscarPorId(idServico));
	}
	
	@DeleteMapping("/deletar/{idServico}")
	public ResponseEntity<String> deletarPorId(@PathVariable Integer idServico) {
		return ResponseEntity.ok(servicoService.deletarPorId(idServico));
	}
	
	@PostMapping("/atualizar/{idServico}")
	public ResponseEntity<String> atualizarPorId(@PathVariable Integer idServico, @RequestBody ServicoDTO servicoDTO) throws ServicoException {
		return ResponseEntity.ok(servicoService.atualizarPorId(idServico, servicoDTO));
		
	}
	@PostMapping("/salvar-varios")
	public ResponseEntity<String> salvarVarios(@RequestBody List<ServicoDTO> listaServicoDTO){
		return ResponseEntity.ok(servicoService.salvarMuitos(listaServicoDTO));
		
	}
	
	@GetMapping("/relatorio")
	public List<RelatorioDTO> relatorio() {
		return servicoService.relatorio();
	}

}
