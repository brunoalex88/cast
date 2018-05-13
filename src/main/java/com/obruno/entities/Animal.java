package com.obruno.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "animal")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Nome do animal é obrigatório")
	private String nome;

	@NotNull(message = "Data do recolhimento do animal é obrigatória!")
	@Column(name = "data_recolhimento")
	private Date dataRecolhimento;

	@Column(name = "data_adocao")
	private Date dataAdocao;

	@NotEmpty(message = "Tag de identificação do animal é obrigatória!")
	private String tag;

	@NotNull(message = "Sexo do animal é obrigatório!")
	@Enumerated()
	private SexoAnimal sexo;

	@NotNull(message = "Gênero do animal é obrigatório!")
	@Enumerated()
	private Genero genero;

	@ManyToOne()
	@JoinColumn(name = "adotante_id")
	private Adotante adotante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataRecolhimento() {
		return dataRecolhimento;
	}

	public void setDataRecolhimento(Date dataRecolhimento) {
		this.dataRecolhimento = dataRecolhimento;
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public SexoAnimal getSexo() {
		return sexo;
	}

	public void setSexo(SexoAnimal sexo) {
		this.sexo = sexo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Adotante getAdotante() {
		return adotante;
	}

	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adotante == null) ? 0 : adotante.hashCode());
		result = prime * result + ((dataAdocao == null) ? 0 : dataAdocao.hashCode());
		result = prime * result + ((dataRecolhimento == null) ? 0 : dataRecolhimento.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
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
		Animal other = (Animal) obj;
		if (adotante == null) {
			if (other.adotante != null)
				return false;
		} else if (!adotante.equals(other.adotante))
			return false;
		if (dataAdocao == null) {
			if (other.dataAdocao != null)
				return false;
		} else if (!dataAdocao.equals(other.dataAdocao))
			return false;
		if (dataRecolhimento == null) {
			if (other.dataRecolhimento != null)
				return false;
		} else if (!dataRecolhimento.equals(other.dataRecolhimento))
			return false;
		if (genero != other.genero)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", dataRecolhimento=" + dataRecolhimento + ", dataAdocao="
				+ dataAdocao + ", tag=" + tag + ", sexo=" + sexo + ", genero=" + genero + ", adotante=" + adotante
				+ "]";
	}

}
