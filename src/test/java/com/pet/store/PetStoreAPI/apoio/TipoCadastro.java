package com.pet.store.PetStoreAPI.apoio;

public enum TipoCadastro {

	PET("pet"), CLIENTE("cliente"), VENDA("venda");

	private String opcao;

	private TipoCadastro(String opcao) {
		this.opcao = opcao;
	}

	public String getOpcao() {
		return opcao;
	}

}
