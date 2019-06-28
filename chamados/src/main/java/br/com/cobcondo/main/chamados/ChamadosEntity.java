package br.com.cobcondo.main.chamados;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.cobcondo.main.utils.BaseEntity;

@Entity
@Table(name="chamados")
@AttributeOverride(name="id", column=@Column(name="cha_id"))
public class ChamadosEntity extends BaseEntity<Long>{
	private static final long serialVersionUID =1L;
	
	@Column(name="cha_desc", length=45, nullable = false)
	private String chaDesc;

	public ChamadosEntity() {
		super();
	}
	public ChamadosEntity(String chaDesc) {
		super();
		this.chaDesc = chaDesc;
	}

	public String getChaDesc() {
		return chaDesc;
	}

	public void setChaDesc(String chaDesc) {
		this.chaDesc = chaDesc;
	}
	
	
	
}


