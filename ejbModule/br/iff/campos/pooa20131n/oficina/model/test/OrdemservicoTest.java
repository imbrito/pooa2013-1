package br.iff.campos.pooa20131n.oficina.model.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.oficina.model.entity.Ordemservico;
import br.iff.campos.pooa20131n.oficina.model.persistence.OrdemservicoPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.ProprietarioPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.VeiculoPersistence;

public class OrdemservicoTest {

	private ProprietarioPersistence pprop = new ProprietarioPersistence();
	private VeiculoPersistence pveic = new VeiculoPersistence();
	private OrdemservicoPersistence pord = new OrdemservicoPersistence();
	private String uid = "001";
	private Date dataos = new Date();

	@Test
	public void testInserir() {
		pprop.inserir(uid, "bairro", "cidade", "complemento", "cpf", 20, "nome", "rua", "uf");
		pveic.inserir(uid, 2013, "cor", "modelo", "placa", pprop.find(uid));
		Ordemservico ord = pord.inserir(uid, dataos, pveic.find(uid));
		assertEquals(ord.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Ordemservico ord = pord.update(uid, dataos, pveic.find(uid));
		assertEquals(ord.getUid(), uid);
	}

	@Test
	public void testFindString() {
		Ordemservico ord = pord.find(uid);
		assertEquals(ord.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Ordemservico> lista_pord = pord.findAll();
		for (Ordemservico ordemservico : lista_pord) {
			assertEquals(ordemservico.getUid(), uid);
		}
	}

	@Test
	public void testDelete() {
		pord.delete(uid);
		pveic.delete(uid);
		pprop.delete(uid);
	}

}
