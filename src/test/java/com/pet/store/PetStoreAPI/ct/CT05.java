package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoCadastro;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT05 {

	final static Log log = LogFactory.getLog(CT05.class);

	@Test
	public void ct05() throws Exception{
		
		System.setProperty("log4jFileName", "CT05");
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Inicio caso de Teste - CT05 - Efetuar venda de Pet na api PetStore");
		
		try{
			
			MassaDados massa = new MassaDados(TipoCadastro.VENDA.getOpcao(),"CT05");
			PetStoreAPI api  = new PetStoreAPI();
			Validacao validacao = new Validacao();
			validacao.validarCadastro(TipoCadastro.VENDA,api.efetuarVendaPet(massa));

		}catch(Exception e){
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}
}
