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

public class CT10 {

	final static Log log = LogFactory.getLog(CT10.class);

	@Test
	public void ct10() throws Exception {

		System.setProperty("log4jFileName", "CT10");
		PropertyConfigurator.configure("log4j.properties");

		log.info("Inicio caso de Teste - CT10 - efetuar a venda de 10 Pets a 5 clientes e consultar na API PetStore");

		try {

			MassaDados[] massa = new MassaDados[10];
			for (int i = 0; i < 10; i++) {
				int h = i+1;
				log.info("Cadastrando " + h + "ª `Pet:");
				massa[i] = (new MassaDados(TipoCadastro.VENDA.getOpcao(), "CT10", i));
				PetStoreAPI api  = new PetStoreAPI();
				Validacao validacao = new Validacao();
				validacao.validarCadastro(TipoCadastro.VENDA, api.efetuarVendaPet(massa[i]));
				validacao.validarConsulta(TipoConsulta.VENDA,api.consultarVenda(massa[i].getId()), massa[i].getId());
			}

		} catch (Exception e) {
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}

}
