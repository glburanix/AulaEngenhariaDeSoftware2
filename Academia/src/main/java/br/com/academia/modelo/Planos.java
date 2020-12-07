package br.com.academia.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
public class Planos {

	@Id
	
	@Column(name="id", nullable=false, unique=true)
    private int id;
    
    private String nome_plano;

	private double valor_plano;

	private int duracao_plano;
	
    @Column(name="planos", nullable=false, unique=false)
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome_plano() {
		return nome_plano;
	}

	public void setNome_plano(String nome_plano) {
		this.nome_plano = nome_plano;
	}
	
	public double getValor_plano() {
		return valor_plano;
	}

	public void setValor_plano(double valor_plano) {
		this.valor_plano = valor_plano;
	}
	
	public int getDuracao_plano() {
		return id;
	}

	public void setDuracao_plano(int duracao_plano) {
		this.duracao_plano = duracao_plano;
	}
	

}
