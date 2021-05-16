package com.pet.store.PetStoreAPI.ct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.pet.store.PetStoreAPI.api.PetStoreAPI;
import com.pet.store.PetStoreAPI.apoio.TipoConsulta;
import com.pet.store.PetStoreAPI.func.MassaDados;
import com.pet.store.PetStoreAPI.func.Validacao;

public class CT02{
	
	final static Log log = LogFactory.getLog(CT02.class);

	@Test
	public void ct02() throws Exception{
		
		System.setProperty("log4jFileName", "CT02");
		PropertyConfigurator.configure("log4j.properties");
		
		log.info("Inicio caso de Teste - CT02 - Verificar cliente cadastrado na api PetStore");
		
		try{
			
			MassaDados massa = new MassaDados(TipoConsulta.CLIENTE.getOpcao(),"CT02");
			PetStoreAPI api  = new PetStoreAPI();
			Validacao validacao = new Validacao();
			validacao.validarConsultaCliente(api.consultarCliente(massa.getName()), massa.getName());

		}catch(Exception e){
			log.info("Erro ao executar caso de teste");
			throw e;
		}
	}

}
