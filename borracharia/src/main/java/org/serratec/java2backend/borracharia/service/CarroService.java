package org.serratec.java2backend.borracharia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.borracharia.dto.CarroDTO;
import org.serratec.java2backend.borracharia.exception.CarroException;
import org.serratec.java2backend.borracharia.model.Carro;
import org.serratec.java2backend.borracharia.repository.CarroRepository;
import org.serratec.java2backend.borracharia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;

	public Carro dtoModel(CarroDTO carroDTO, Carro carro) {

		carro.setModelo(carroDTO.getModelo());
		carro.setMarca(carroDTO.getMarca());
		carro.setAno(carroDTO.getAno());
	
		if(carroDTO.getIdCliente() != null) {
			carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
		}
		return carro;
	}

	public CarroDTO modelDto(Carro carro, CarroDTO carroDTO) {

		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setAno(carro.getAno());
		carroDTO.setIdCliente(carro.getCliente().getIdCliente());

		return carroDTO;
	}

	public String salvar(CarroDTO carroDTO) {
		Carro carro = new Carro();
		dtoModel(carroDTO, carro);
		carroRepository.save(carro);
		return "Carro criado com sucesso!";

	}

	public String salvarMuitos(List<CarroDTO> listaCarroDTO) {
		List<Carro> listaCarroModel = new ArrayList<>();
		for (CarroDTO carroDTO : listaCarroDTO) {
			Carro carro = new Carro();
			dtoModel(carroDTO, carro);
			listaCarroModel.add(carro);
		}
		carroRepository.saveAll(listaCarroModel);
		return "Veículos cadastrados com sucesso!";
	}

	public List<CarroDTO> listarTodos() {
		List<Carro> listaCarros = carroRepository.findAll();
		List<CarroDTO> listaCarrosDto = new ArrayList<>();

		for (Carro carro : listaCarros) {
			CarroDTO carroDTO = new CarroDTO();
			modelDto(carro, carroDTO);
			listaCarrosDto.add(carroDTO);
		}
		return listaCarrosDto;
	}

	public CarroDTO buscarPorId(Integer idCarro) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCarro);
		Carro carroModel = new Carro();
		CarroDTO carroDTO = new CarroDTO();
		if (carro.isPresent()) {
			carroModel = carro.get();
			modelDto(carroModel, carroDTO);
			return carroDTO;
		}
		throw new CarroException("Carro com  ID informado não encontrado");

	}

	public String atualizar(Integer idCarro, CarroDTO carroDTO) throws CarroException {
		Optional<Carro> carro = carroRepository.findById(idCarro);
		Carro carroModel = new Carro();
		if (carro.isPresent()) {
			carroModel = carro.get();
			if (carroDTO.getModelo() != null) {
				carroModel.setModelo(carroDTO.getModelo());
			}
			if (carroDTO.getMarca() != null) {
				carroModel.setMarca(carroDTO.getMarca());
			}
			if (carroDTO.getAno() != null) {
				carroModel.setAno(carroDTO.getAno());
			}
			carroRepository.save(carroModel);
			return "Veículo atualizado!";
		}
		throw new CarroException("Veículo Não Atualizado!");
	}

	public String deletar(Integer idCarro) {
		carroRepository.deleteById(idCarro);
		return "### O Carro foi excluído com sucesso! ###";
	}

}
