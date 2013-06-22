package br.iff.campos.pooa20131n.oficina.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mecanico database table.
 * 
 */
@Entity
public class Mecanico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String especialidade;

	private String nome;

	private String telefone;

	//bi-directional many-to-one association to Itenso
	@OneToMany(mappedBy="mecanico")
	private List<Itenso> itensos;

	public Mecanico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Itenso> getItensos() {
		return this.itensos;
	}

	public void setItensos(List<Itenso> itensos) {
		this.itensos = itensos;
	}

	public Itenso addItenso(Itenso itenso) {
		getItensos().add(itenso);
		itenso.setMecanico(this);

		return itenso;
	}

	public Itenso removeItenso(Itenso itenso) {
		getItensos().remove(itenso);
		itenso.setMecanico(null);

		return itenso;
	}

}