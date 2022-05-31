package org.serratec.java2backend.borracharia.controller;

import java.util.List;

import org.serratec.java2backend.borracharia.dto.ClienteDTO;
import org.serratec.java2backend.borracharia.exception.ClienteException;
import org.serratec.java2backend.borracharia.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
	
		@Autowired
		ClienteService clienteService;
		
		@PostMapping("/salvar")
		public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) {
		return ResponseEntity.ok(clienteService.salvar(clienteDTO));
		}
		
		@GetMapping("/buscar/{idCliente}")
		public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException {
			return ResponseEntity.ok(clienteService.buscarPorId(idCliente));	
		}
		
		@PutMapping("/atualizar/{idCliente}")
		public ResponseEntity<String> atualizar(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO) throws ClienteException {
			return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
		}
		
		@DeleteMapping("/delete/{idCliente}")
		public ResponseEntity<String> delelte(@PathVariable Integer idCliente) {
			return ResponseEntity.ok(clienteService.delete(idCliente));
			
		}
		
		@GetMapping("/listar")
		public ResponseEntity<List<ClienteDTO>> listasTodos() {
			return ResponseEntity.ok(clienteService.listarTodos());
		}
		
		@PostMapping("/salvar-varios")
		public ResponseEntity<String> salvarVarios(@RequestBody List<ClienteDTO> listaClienteDTO) {
			return ResponseEntity.ok(clienteService.salvarVarios(listaClienteDTO));
			
		}
		
		
}