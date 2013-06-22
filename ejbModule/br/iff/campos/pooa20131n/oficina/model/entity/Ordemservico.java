package br.iff.campos.pooa20131n.oficina.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordemservico database table.
 * 
 */
@Entity
public class Ordemservico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	@Temporal(TemporalType.DATE)
	private Date dataos;

	//bi-directional many-to-one association to Itenso
	@OneToMany(mappedBy="ordemservico")
	private List<Itenso> itensos;

	//bi-directional many-to-one association to Veiculo
	@ManyToOne
	@JoinColumn(name="uidveiculo")
	private Veiculo veiculo;

	public Ordemservico() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDataos() {
		return this.dataos;
	}

	public void setDataos(Date dataos) {
		this.dataos = dataos;
	}

	public List<Itenso> getItensos() {
		return this.itensos;
	}

	public void setItensos(List<Itenso> itensos) {
		this.itensos = itensos;
	}

	public Itenso addItenso(Itenso itenso) {
		getItensos().add(itenso);
		itenso.setOrdemservico(this);

		return itenso;
	}

	public Itenso removeItenso(Itenso itenso) {
		getItensos().remove(itenso);
		itenso.setOrdemservico(null);

		return itenso;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}