package com.obruno.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "adotante")
public class Adotante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Nome do adotante é obrigatório")
	@Size(min=3, max=80, message="Quantidade mínima de caracteres é 3 e a máxima é 80")
	private String nome;

	private String rg;
	private String cpf;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Enumerated
	private Sexo sexo;

	private String endereco;
	private String bairro;
	private String numero;

	@Column(name = "quant_animais")
	private Integer quantidadeDeAnimais;
	private String profissao;

	@Column(name = "quant_moradores")
	private Integer quantMoradores;

	@Column(name = "area_local")
	private Integer areaLocal;

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getQuantidadeDeAnimais() {
		return quantidadeDeAnimais;
	}

	public void setQuantidadeDeAnimais(Integer quantidadeDeAnimais) {
		this.quantidadeDeAnimais = quantidadeDeAnimais;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Integer getQuantMoradores() {
		return quantMoradores;
	}

	public void setQuantMoradores(Integer quantMoradores) {
		this.quantMoradores = quantMoradores;
	}

	public Integer getAreaLocal() {
		return areaLocal;
	}

	public void setAreaLocal(Integer areaLocal) {
		this.areaLocal = areaLocal;
	}

	@Override
	public String toString() {
		return "Adotante [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", sexo=" + sexo + ", endereco=" + endereco + ", bairro=" + bairro + ", numero="
				+ numero + ", quantidadeDeAnimais=" + quantidadeDeAnimais + ", profissao=" + profissao
				+ ", quantMoradores=" + quantMoradores + ", areaLocal=" + areaLocal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaLocal == null) ? 0 : areaLocal.hashCode());
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((quantMoradores == null) ? 0 : quantMoradores.hashCode());
		result = prime * result + ((quantidadeDeAnimais == null) ? 0 : quantidadeDeAnimais.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Adotante other = (Adotante) obj;
		if (areaLocal == null) {
			if (other.areaLocal != null)
				return false;
		} else if (!areaLocal.equals(other.areaLocal))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (quantMoradores == null) {
			if (other.quantMoradores != null)
				return false;
		} else if (!quantMoradores.equals(other.quantMoradores))
			return false;
		if (quantidadeDeAnimais == null) {
			if (other.quantidadeDeAnimais != null)
				return false;
		} else if (!quantidadeDeAnimais.equals(other.quantidadeDeAnimais))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

}
