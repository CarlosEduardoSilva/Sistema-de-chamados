package br.com.cobcondo.main.chamados;
import java.util.UUID;	
import javax.servlet.http.HttpSession;	

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobcondo.main.chamados.ChamadosEntity;
import br.com.cobcondo.main.chamados.ChamadosRepository;
import br.com.cobcondo.main.usuarios.UsuariosRepository;
@RestController
public class ChamadosService {
	
	
	private final Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	private ChamadosRepository ChamadosRepository;
	
	//data:{usuNome:usuNome, empresa:empresa, cat:cat, subcat:subcat, titulo:titulo, descricao:descricao},
	@RequestMapping(value="/crchamados", method=RequestMethod.POST, 
			params={"usuNome", "empresa", "cat", "subcat", "titulo","descricao"})	
	public String crchamados(@RequestParam("usuNome") String usuNome,
			@RequestParam("empresa") Long empresa,
			@RequestParam("cat") Long cat, 
			@RequestParam("subcat") Long subcat, 
			@RequestParam("titulo") String titulo,			
			@RequestParam("descricao") String descricao,
			HttpSession session) {
		this.LOGGER.info("Incluindo chamado:");
		String ret = "OK";
		try {
					
					ChamadosEntity chamado = new ChamadosEntity(usuNome, empresa, cat, subcat, titulo, descricao);
					this.ChamadosRepository.saveAndFlush(chamado);					
					
			
			
		} catch (Exception e) {
		e.printStackTrace();
		ret = "error";
		}
	
		return ret;
		
	}
	
}
