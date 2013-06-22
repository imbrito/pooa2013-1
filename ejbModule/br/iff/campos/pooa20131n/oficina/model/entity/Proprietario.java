package br.iff.campos.pooa20131n.oficina.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proprietario database table.
 * 
 */
@Entity
public class Proprietario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String bairro;

	private String cidade;

	private String complemento;

	private String cpf;

	private Integer idade;

	private String nome;

	private String rua;

	private String uf;

	//bi-directional many-to-one association to Veiculo
	@OneToMany(mappedBy="proprietario")
	private List<Veiculo> veiculos;

	public Proprietario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return this.idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public Veiculo addVeiculo(Veiculo veiculo) {
		getVeiculos().add(veiculo);
		veiculo.setProprietario(this);

		return veiculo;
	}

	public Veiculo removeVeiculo(Veiculo veiculo) {
		getVeiculos().remove(veiculo);
		veiculo.setProprietario(null);

		return veiculo;
	}

}