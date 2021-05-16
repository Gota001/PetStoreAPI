package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoConsulta;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT06{
	
	final static Log log = LogFactory.getLog(CT06.class);

	@Test
	public void ct06() throws Exception{
		
		System.setProperty("log4jFileName", "CT06");
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Inicio caso de Teste - CT06 - Verificar compra na api PetStore");
		
		try{
			
			MassaDados massa = new MassaDados(TipoConsulta.VENDA.getOpcao(),"CT06");
			PetStoreAPI api  = new PetStoreAPI();
			Validacao validacao = new Validacao();
			validacao.validarConsulta(TipoConsulta.VENDA, api.consultarVenda(massa.getId()), massa.getId());

		}catch(Exception e){
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}

}
