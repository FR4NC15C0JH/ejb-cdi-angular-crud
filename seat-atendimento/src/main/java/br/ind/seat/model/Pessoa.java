package br.ind.seat.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PES_PESSOA")
@Cacheable
public class Pessoa {

	public static final String COL_ID = "COD_NU_SRV";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = COL_ID)
	private Long id;

	@Column(name = "PES_ST_NOME")
	@Size(max = 45)
	private String nome;

	@Column(name = "PES_DT_DATA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataDeNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
