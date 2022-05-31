package org.serratec.java2backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.serratec.java2backend.borracharia.dto.ClienteDTO;
import org.serratec.java2backend.borracharia.exception.ClienteException;
import org.serratec.java2backend.borracharia.model.Cliente;
import org.serratec.java2backend.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente dtoModel(ClienteDTO clienteDTO, Cliente cliente) {

		cliente.setNomeCliente(clienteDTO.getNomeCliente());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNumTel(clienteDTO.getNumTel());
		cliente.setEmail(clienteDTO.getEmail());

		return cliente;
	}

	public ClienteDTO modelDto(Cliente cliente, ClienteDTO clienteDTO) {

		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNomeCliente(cliente.getNomeCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNumTel(cliente.getNumTel());
		clienteDTO.setEmail(cliente.getEmail());

		return clienteDTO;

	}
	
	public String salvar(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		dtoModel(clienteDTO, cliente);
		clienteRepository.save(cliente);
		return "Cliente criado com o id: " + cliente.getIdCliente();
	}

	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		Cliente clienteNoBanco = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();

		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			clienteDTO = modelDto(clienteNoBanco, clienteDTO);
			return clienteDTO;
		}
		throw new ClienteException("Cliente não encontrado - Deu ruim");

	}

	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = new Cliente();
		
		if(cliente.isPresent()) {
			clienteNoBanco = cliente.get();
		
			if (clienteDTO.getNomeCliente() != null) {
				clienteNoBanco.setNomeCliente(clienteDTO.getNomeCliente());
			}
			if (clienteDTO.getCpf() != null) {
				clienteNoBanco.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getNumTel() != null) {
				clienteNoBanco.setNumTel(clienteDTO.getNumTel());
			}	
			if (clienteDTO.getEmail() != null) {
				clienteNoBanco.setEmail(clienteDTO.getEmail());
			}
			clienteRepository.save(clienteNoBanco);
			return "Cliente atualizado!";
		}
		throw new ClienteException("O cliente não foi atualizado");
	}
	
	public String delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
		return "Cliente excluído com sucesso!";
	}
	
	public List<ClienteDTO> listarTodos() {
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<>();
		for (Cliente cliente : listaCliente) {
			ClienteDTO clienteDTO = new ClienteDTO();
			modelDto(cliente, clienteDTO);
			listaDTO.add(clienteDTO);
		}
		return listaDTO;
	}
	
	public String salvarVarios(List<ClienteDTO> listaClienteDTO) {
		List<Cliente> listaClientes = new ArrayList<>();
		for (ClienteDTO clienteDTO : listaClienteDTO) {
		Cliente cliente = new Cliente();
		dtoModel(clienteDTO, cliente);
		listaClientes.add(cliente);
	}
	clienteRepository.saveAll(listaClientes);	
	return "Clientes salvos com sucesso!";
}

}


