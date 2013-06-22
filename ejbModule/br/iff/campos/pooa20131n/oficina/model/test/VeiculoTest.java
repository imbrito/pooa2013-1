package br.iff.campos.pooa20131n.oficina.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import br.iff.campos.pooa20131n.oficina.model.entity.Proprietario;
import br.iff.campos.pooa20131n.oficina.model.entity.Veiculo;
import br.iff.campos.pooa20131n.oficina.model.persistence.ProprietarioPersistence;
import br.iff.campos.pooa20131n.oficina.model.persistence.VeiculoPersistence;

public class VeiculoTest {

	private ProprietarioPersistence pprop = new ProprietarioPersistence();
	private VeiculoPersistence pveic = new VeiculoPersistence();
	private String uid = "001";

	@Test
	public void testInserir() {
		pprop.inserir(uid, "bairro", "cidade", "complemento", "cpf", 20, "nome", "rua", "uf");
		Veiculo veic = pveic.inserir(uid, 2013, "cor",
				"modelo", "placa", pprop.find(uid));
		assertEquals(veic.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Veiculo veic = pveic.update(uid, 2013, "corUP",
				"modelo", "placa", pprop.find(uid));
		assertEquals(veic.getCor(), "corUP");
	}

	@Test
	public void testFindString() {
		Veiculo veic = pveic.find(uid);
		assertEquals(veic.getModelo(), "modelo");
	}

	@Test
	public void testFindAll() {
		List<Veiculo> lista_pveic = pveic.findAll();
		for(Veiculo veiculo : lista_pveic){
			assertEquals(veiculo.getModelo(), "modelo");
		}
	}

	@Test
	public void testDelete() {
		pveic.delete(uid);
		pprop.delete(uid);
	}

}