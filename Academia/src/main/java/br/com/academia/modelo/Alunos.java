package br.com.academia.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/* se o nome da tabela fosse exatamente o nome da classe (Disciplina),
  o uso de Anottation seria opcional 
  obs: o mesmo vale para @Column*/

@Entity
public class Alunos {

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "SEQ_DISCIPLINA") // os parametros são valido apenas para SGDBs que possuem
	// sequence
	// @SequenceGenerator(name = "SEQ_DISCIPLINA", sequenceName = "SEQ_DISCIPLINA",
	// allocationSize = 1) // valido apenas para Database que possuem sequence

	@Column(name = "id", nullable = false, unique = true) // oracle tem problemas com id = unique=true
	private int id;
	private int idade;

	private double altura;
	private double peso;
	private Date data_inicio;

	private String cpf;
	private String nome;
	private String sexo;

	@Column(name = "alunos", nullable = false, unique = false)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSex() {
		return sexo;
	}

	public void setSex(String sexo) {
		this.sexo = sexo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Date getDataInicio() {
		return data_inicio;
	}

	public void setDataInicio(Date data_inicio) {
		this.data_inicio = data_inicio;

	}

	public Alunos() {

	}

}