package org.serratec.java2backend.borracharia.controller;

import javax.mail.MessagingException;


import org.serratec.java2backend.borracharia.dto.ServicoDTO;
import org.serratec.java2backend.borracharia.exception.EmailException;
import org.serratec.java2backend.borracharia.service.CarroService;
import org.serratec.java2backend.borracharia.service.EmailService;
import org.serratec.java2backend.borracharia.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	CarroService carroService;
	
	@Autowired
	ServicoService servicoService;
	
	@GetMapping("/email")
	public void enviarEmail(ServicoDTO servicoDTO) throws MessagingException, EmailException {
		emailService.emailTeste(servicoDTO);
	}
	

}
