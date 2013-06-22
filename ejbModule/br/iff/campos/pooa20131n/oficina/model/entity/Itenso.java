package br.iff.campos.pooa20131n.oficina.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the itensos database table.
 * 
 */
@Entity
@Table(name="itensos")
public class Itenso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	@Temporal(TemporalType.DATE)
	private Date datafim;

	@Temporal(TemporalType.DATE)
	private Date datainicio;

	private Timestamp horafim;

	private Timestamp horainicio;

	//bi-directional many-to-one association to Mecanico
	@ManyToOne
	@JoinColumn(name="uidmecanio")
	private Mecanico mecanico;

	//bi-directional many-to-one association to Ordemservico
	@ManyToOne
	@JoinColumn(name="uidordemservico")
	private Ordemservico ordemservico;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="uidservico")
	private Servico servico;

	public Itenso() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDatafim() {
		return this.datafim;
	}

	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}

	public Date getDatainicio() {
		return this.datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Timestamp getHorafim() {
		return this.horafim;
	}

	public void setHorafim(Timestamp horafim) {
		this.horafim = horafim;
	}

	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}

	public Mecanico getMecanico() {
		return this.mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Ordemservico getOrdemservico() {
		return this.ordemservico;
	}

	public void setOrdemservico(Ordemservico ordemservico) {
		this.ordemservico = ordemservico;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}