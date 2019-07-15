package br.com.cobcondo.main.chamados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cobcondo.main.chamados.ChamadosEntity;


public interface ChamadosRepository extends JpaRepository<ChamadosEntity, Long> {
	
	
	
	public List<ChamadosEntity> findByUsuId(Long usuId);
	
	

}
