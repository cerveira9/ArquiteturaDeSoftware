package com.fsma.arquitetura.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "cidade", indexes = {
		@Index(name="buscacidade_nome", columnList = "nome, uf_fk")
})
public class Cidade implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	@JoinColumn(name = "uf_fk")
	@OneToOne
	private Uf uf;
	
	public Cidade() {}
	
	public Cidade(String nome , Uf uf) {
		this.nome = nome;
		this.uf = uf;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + "]";
	}
	
}
