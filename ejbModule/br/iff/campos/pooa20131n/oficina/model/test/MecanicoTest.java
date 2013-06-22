package br.iff.campos.pooa20131n.oficina.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.oficina.model.entity.Mecanico;
import br.iff.campos.pooa20131n.oficina.model.persistence.MecanicoPersistence;

public class MecanicoTest {

	private MecanicoPersistence pmec = new MecanicoPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		Mecanico mec = pmec.inserir(uid, "especialidade", "nome", "telefone");
		assertEquals(mec.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Mecanico mec = pmec.update(uid, "especialidade", "nomeUp", "telefone");
		assertEquals(mec.getNome(), "nomeUp");
	}

	@Test
	public void testFind() {
		Mecanico mec = pmec.find(uid);
		assertEquals(mec.getEspecialidade(), "especialidade");
	}

	@Test
	public void testFindAll() {
		List<Mecanico> lista_pmec = pmec.findAll();
		for (Mecanico mecanico : lista_pmec) {
			assertEquals(mecanico.getTelefone(), "telefone");
		}
	}

	@Test
	public void testDeleteString() {
		pmec.delete(uid);
	}

}
