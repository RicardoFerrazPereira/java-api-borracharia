package org.serratec.java2backend.borracharia.controller;

import java.util.List;

import org.serratec.java2backend.borracharia.dto.CarroDTO;
import org.serratec.java2backend.borracharia.exception.CarroException;
import org.serratec.java2backend.borracharia.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CarroDTO carroDTO) {
		return ResponseEntity.ok(carroService.salvar(carroDTO));
	}

	@PostMapping("/salvar-muitos")
	public ResponseEntity<String> salvarTodos(@RequestBody List<CarroDTO> listaCarroDTO) {
		return ResponseEntity.ok(carroService.salvarMuitos(listaCarroDTO));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<CarroDTO>> listar() {
		return ResponseEntity.ok(carroService.listarTodos());
	}

	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroDTO> buscarCarroPorId(@PathVariable Integer idCarro) throws CarroException {
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}

	@PutMapping("/atualizar/{idCarro}")
	public ResponseEntity<String> atualizarPorId(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO)
			throws CarroException {
		return ResponseEntity.ok(carroService.atualizar(idCarro, carroDTO));
	}
	
	@DeleteMapping("/deletar/{idCarro}")
	public ResponseEntity<String> deletarPorId(@PathVariable Integer idCarro){
		return ResponseEntity.ok(carroService.deletar(idCarro));
	}

}
