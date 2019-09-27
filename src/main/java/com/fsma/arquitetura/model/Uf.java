package com.fsma.arquitetura.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "uf", indexes = {
		@Index(name="buscauf_nome", columnList = "nome")
})
public class Uf implements Serializable{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	@Column(name = "sigla", nullable = false, length = 2)
	private String sigla;
	
	public Uf() {}
	
	public Uf(String nome , String sigla) {
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		Uf other = (Uf) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Uf [sigla=" + sigla + "]";
	}
	
	
	
}
