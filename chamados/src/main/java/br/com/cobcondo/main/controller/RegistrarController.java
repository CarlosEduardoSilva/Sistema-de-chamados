package br.com.cobcondo.main.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

public class RegistrarController {
private final Logger LOGGER = Logger.getLogger(getClass());
	
	
	@RequestMapping("/registrar")
	public String paginaRegistrar (HttpSession session) {
		
		session.invalidate();
		this.LOGGER.info("Chamada da pagina Registrar");
		return "registrar/registrar";
	}
}
