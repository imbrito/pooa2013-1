package br.iff.campos.pooa20131n.oficina.model.persistence;

import java.util.List;

import br.iff.campos.pooa20131n.oficina.model.entity.Proprietario;

public class ProprietarioPersistence extends AbstractPersistence {

	public Proprietario inserir(String uid, String bairro, String cidade,
			String complemento, String cpf, Integer idade, String nome,
			String rua, String uf) {

		Proprietario proprietario = new Proprietario();

		proprietario.setUid(uid);
		proprietario.setBairro(bairro);
		proprietario.setCidade(cidade);
		proprietario.setComplemento(complemento);
		proprietario.setCpf(cpf);
		proprietario.setNome(nome);
		proprietario.setRua(rua);
		proprietario.setUf(uf);
		proprietario.setIdade(idade);
		super.insert(proprietario);

		return proprietario;

	}

	public Proprietario update(String uid, String bairro, String cidade,
			String complemento, String cpf, Integer idade, String nome,
			String rua, String uf) {

		Proprietario proprietario = super.find(Proprietario.class, uid);

		proprietario.setUid(uid);
		proprietario.setBairro(bairro);
		proprietario.setCidade(cidade);
		proprietario.setComplemento(complemento);
		proprietario.setCpf(cpf);
		proprietario.setNome(nome);
		proprietario.setRua(rua);
		proprietario.setUf(uf);
		proprietario.setIdade(idade);
		super.update(proprietario);

		return proprietario;

	}

	public Proprietario find(String uid) {

		return super.find(Proprietario.class, uid);
	}

	public void delete(String uid) {
		super.delete(Proprietario.class, uid);
	}

	public List<Proprietario> findAll() {
		return super.findAll(Proprietario.class);

	}

}
