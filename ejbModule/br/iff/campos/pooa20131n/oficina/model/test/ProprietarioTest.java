package br.iff.campos.pooa20131n.oficina.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.oficina.model.entity.Proprietario;
import br.iff.campos.pooa20131n.oficina.model.persistence.ProprietarioPersistence;

public class ProprietarioTest {

	private ProprietarioPersistence pprop = new ProprietarioPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		Proprietario prop = pprop.inserir(uid, "bairro", "cidade",
				"complemento", "cpf", 20, "nome", "rua", "uf");
		assertEquals(prop.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Proprietario prop = pprop.update(uid, "bairroUP", "cidade",
				"complemento", "cpf", 20, "nome", "rua", "uf");
		assertEquals(prop.getBairro(), "bairroUP");
	}

	@Test
	public void testFind() {
		Proprietario prop = pprop.find(uid);
		assertEquals(prop.getCidade(), "cidade");
	}

	@Test
	public void testFindAll() {
		List<Proprietario> lista_proop = pprop.findAll();
		for (Proprietario proprietario : lista_proop) {
			assertEquals(proprietario.getCidade(), "cidade");
		}
	}

	@Test
	public void testDeleteString() {
		pprop.delete(uid);
	}

}