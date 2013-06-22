package br.iff.campos.pooa20131n.oficina.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.oficina.model.entity.Servico;
import br.iff.campos.pooa20131n.oficina.model.persistence.ServicoPersistence;

public class ServicoTest {

	private ServicoPersistence pserv = new ServicoPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		Servico serv = pserv.inserir(uid, "descricao", 200, 2);
		assertEquals(serv.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Servico serv = pserv.update(uid, "descricaoUp", 200, 2);
		assertEquals(serv.getDescricao(), "descricaoUp");
	}

	@Test
	public void testFind() {
		Servico serv = pserv.find(uid);
		assertEquals(serv.getUid(), uid);
	}

	@Test
	public void testFindAll() {
		List<Servico> lista_pserv = pserv.findAll();
		for (Servico servico : lista_pserv) {
			assertEquals(servico.getUid(), uid);
		}
	}

	@Test
	public void testDeleteString() {
		pserv.delete(uid);
	}

}
