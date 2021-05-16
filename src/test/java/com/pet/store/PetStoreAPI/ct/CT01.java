package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoCadastro;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT01 {

	final static Log log = LogFactory.getLog(CT01.class);

	@Test
	public void ct01() throws Exception{
		
		System.setProperty("log4jFileName", "CT01");
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Inicio caso de Teste - CT01 - Cadastrar cliente na api PetStore");
		
		try{
			
			MassaDados massa = new MassaDados(TipoCadastro.CLIENTE.getOpcao(),"CT01");
			PetStoreAPI api  = new PetStoreAPI();
			Validacao validacao = new Validacao();
			validacao.validarCadastro(TipoCadastro.CLIENTE,api.cadastrarCliente(massa));
			
		}catch(Exception e){
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}
}
