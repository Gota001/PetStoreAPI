package com.pet.store.PetStoreAPI.apoio;

public enum TipoConsulta {

	PET("pet"), CLIENTE("cliente"), VENDA("venda");

	private String opcao;

	private TipoConsulta(String opcao) {
		this.opcao = opcao;
	}

	public String getOpcao() {
		return opcao;
	}

}
