package br.iff.campos.pooa20131n.oficina.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private Integer ano;

	private String cor;

	private String modelo;

	private String placa;

	//bi-directional many-to-one association to Ordemservico
	@OneToMany(mappedBy="veiculo")
	private List<Ordemservico> ordemservicos;

	//bi-directional many-to-one association to Proprietario
	@ManyToOne
	@JoinColumn(name="uidproprietario")
	private Proprietario proprietario;

	public Veiculo() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Ordemservico> getOrdemservicos() {
		return this.ordemservicos;
	}

	public void setOrdemservicos(List<Ordemservico> ordemservicos) {
		this.ordemservicos = ordemservicos;
	}

	public Ordemservico addOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().add(ordemservico);
		ordemservico.setVeiculo(this);

		return ordemservico;
	}

	public Ordemservico removeOrdemservico(Ordemservico ordemservico) {
		getOrdemservicos().remove(ordemservico);
		ordemservico.setVeiculo(null);

		return ordemservico;
	}

	public Proprietario getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}