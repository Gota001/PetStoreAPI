package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoConsulta;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT04 {

	final static Log log = LogFactory.getLog(CT04.class);

	@Test
	public void ct04() throws Exception{
		
		System.setProperty("log4jFileName", "CT04");
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Inicio caso de Teste - CT04 - Consultar Pet na api PetStore");
		
		try{
			
			MassaDados massa = new MassaDados(TipoConsulta.PET.getOpcao(),"CT04");
			PetStoreAPI api  = new PetStoreAPI();
			Validacao validacao = new Validacao();
			validacao.validarConsulta(TipoConsulta.PET,api.consultarPet(massa.getPetID()),massa.getPetID());

		}catch(Exception e){
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}
}
