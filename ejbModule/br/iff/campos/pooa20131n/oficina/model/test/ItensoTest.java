package br.iff.campos.pooa20131n.oficina.model.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.oficina.model.entity.Itenso;
import br.iff.campos.pooa20131n.oficina.model.persistence.ItensoPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.MecanicoPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.OrdemservicoPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.ProprietarioPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.ServicoPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.VeiculoPersistence;

public class ItensoTest {

	private ProprietarioPersistence pprop = new ProprietarioPersistence();
	private VeiculoPersistence pveic = new VeiculoPersistence();
	private OrdemservicoPersistence pord = new OrdemservicoPersistence();
	private ItensoPersistence pitem = new ItensoPersistence();
	private MecanicoPersistence pmec = new MecanicoPersistence();
	private ServicoPersistence pserv = new ServicoPersistence();
	private String uid = "001";
	private Date dataos = new Date();
	private Date datafim = new Date();
	private Date datainicio = new Date();
	private Timestamp horafim = new Timestamp(System.currentTimeMillis());
	private Timestamp horainicio = new Timestamp(System.currentTimeMillis());

	@Test
	public void testInserir() {
		pprop.inserir(uid, "bairro", "cidade", "complemento", "cpf", 20,
				"nome", "rua", "uf");
		pveic.inserir(uid, 2013, "cor", "modelo", "placa", pprop.find(uid));
		pord.inserir(uid, dataos, pveic.find(uid));
		pserv.inserir(uid, "descricao", 200, 2);
		pmec.inserir(uid, "especialidade", "nome", "telefone");
		Itenso item = pitem.inserir(uid, datafim, datainicio, horafim,
				horainicio, pserv.find(uid), pord.find(uid), pmec.find(uid));
		assertEquals(item.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Itenso item = pitem.update(uid, datafim, datainicio, horafim,
				horainicio, pserv.find(uid), pord.find(uid), pmec.find(uid));
		assertEquals(item.getUid(), uid);
	}

	@Test
	public void testFindString() {
		Itenso item = pitem.find(uid);
		assertEquals(item.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Itenso> lista_pitem = pitem.findAll();
		for (Itenso itensos : lista_pitem) {
			assertEquals(itensos.getUid(), uid);
		}
	}

	@Test
	public void testDelete() {
		pitem.delete(uid);
		pmec.delete(uid);
		pserv.delete(uid);
		pord.delete(uid);
		pveic.delete(uid);
		pprop.delete(uid);
	}
}
