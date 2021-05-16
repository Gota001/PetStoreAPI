package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoCadastro;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT08 {

	final static Log log = LogFactory.getLog(CT08.class);

	@Test
	public void ct08() throws Exception {

		System.setProperty("log4jFileName", "CT08");
		PropertyConfigurator.configure("log4j.properties");

		log.info("Inicio caso de Teste - CT08 - Cadastrar 5 clientes e consultar na API PetStore");

		try {

			MassaDados[] massa = new MassaDados[5];
			for (int i = 0; i < 5; i++) {
				int h = i+1;
				log.info("Cadastrando " + h + "ª cliente:");
				massa[i] = (new MassaDados(TipoCadastro.CLIENTE.getOpcao(), "CT08", i));
				PetStoreAPI api = new PetStoreAPI();
				Validacao validacao = new Validacao();
				validacao.validarCadastro(TipoCadastro.CLIENTE, api.cadastrarCliente(massa[i]));
				validacao.validarConsultaCliente(api.consultarCliente(massa[i].getName()), massa[i].getName());
			}

		} catch (Exception e) {
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}

}
