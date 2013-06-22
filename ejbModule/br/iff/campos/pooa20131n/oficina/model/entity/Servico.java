package br.iff.campos.pooa20131n.oficina.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servico database table.
 * 
 */
@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String descricao;

	private float preco;

	private float tempo;

	//bi-directional many-to-one association to Itenso
	@OneToMany(mappedBy="servico")
	private List<Itenso> itensos;

	public Servico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getTempo() {
		return this.tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public List<Itenso> getItensos() {
		return this.itensos;
	}

	public void setItensos(List<Itenso> itensos) {
		this.itensos = itensos;
	}

	public Itenso addItenso(Itenso itenso) {
		getItensos().add(itenso);
		itenso.setServico(this);

		return itenso;
	}

	public Itenso removeItenso(Itenso itenso) {
		getItensos().remove(itenso);
		itenso.setServico(null);

		return itenso;
	}

}