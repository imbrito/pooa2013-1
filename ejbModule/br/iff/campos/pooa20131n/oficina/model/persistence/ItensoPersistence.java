package br.iff.campos.pooa20131n.oficina.model.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import br.iff.campos.pooa20131n.oficina.model.entity.Itenso;
import br.iff.campos.pooa20131n.oficina.model.entity.Mecanico;
import br.iff.campos.pooa20131n.oficina.model.entity.Ordemservico;
import br.iff.campos.pooa20131n.oficina.model.entity.Servico;

public class ItensoPersistence extends AbstractPersistence {

	public Itenso inserir(String uid, Date datafim, Date datainicio,
			Timestamp horafim, Timestamp horainicio, Servico servico,
			Ordemservico ordemservico, Mecanico mecanico) {

		Itenso itenso = new Itenso();

		itenso.setUid(uid);
		itenso.setDatafim(datafim);
		itenso.setDatainicio(datainicio);
		itenso.setHorafim(horafim);
		itenso.setHorainicio(horainicio);
		itenso.setServico(servico);
		itenso.setOrdemservico(ordemservico);
		itenso.setMecanico(mecanico);
		super.insert(itenso);

		return itenso;

	}

	public Itenso update(String uid, Date datafim, Date datainicio,
			Timestamp horafim, Timestamp horainicio, Servico servico,
			Ordemservico ordemservico, Mecanico mecanico) {

		Itenso itenso = super.find(Itenso.class, uid);

		itenso.setUid(uid);
		itenso.setDatafim(datafim);
		itenso.setDatainicio(datainicio);
		itenso.setHorafim(horafim);
		itenso.setHorainicio(horainicio);
		itenso.setServico(servico);
		itenso.setOrdemservico(ordemservico);
		itenso.setMecanico(mecanico);
		super.update(itenso);

		return itenso;
	}

	public Itenso find(String uid) {

		return super.find(Itenso.class, uid);
	}

	public void delete(String uid) {
		super.delete(Itenso.class, uid);
	}

	public List<Itenso> findAll() {
		return super.findAll(Itenso.class);

	}

}
