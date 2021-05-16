package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoCadastro;
import com.pet.store.PetStoreAPI.apoio.TipoConsulta;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT09 {

	final static Log log = LogFactory.getLog(CT09.class);

	@Test
	public void ct09() throws Exception {

		System.setProperty("log4jFileName", "CT09");
		PropertyConfigurator.configure("log4j.properties");

		log.info("Inicio caso de Teste - CT09 - Cadastrar 10 Pets e consultar na API PetStore");

		try {

			MassaDados[] massa = new MassaDados[10];
			for (int i = 0; i < 10; i++) {
				int h = i+1;
				log.info("Cadastrando " + h + "ª `Pet:");
				massa[i] = (new MassaDados(TipoCadastro.PET.getOpcao(), "CT09", i));
				PetStoreAPI api = new PetStoreAPI();
				Validacao validacao = new Validacao();
				validacao.validarCadastro(TipoCadastro.PET, api.cadastrarPet(massa[i]));
				validacao.validarConsulta(TipoConsulta.PET,api.consultarPet(massa[i].getPetID()), massa[i].getPetID());
			}

		} catch (Exception e) {
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}

}
