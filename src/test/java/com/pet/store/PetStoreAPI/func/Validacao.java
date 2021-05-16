package com.pet.store.PetStoreAPI.func;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.pet.store.PetStoreAPI.apoio.TipoCadastro;
import com.pet.store.PetStoreAPI.apoio.TipoConsulta;

import io.restassured.response.Response;

public class Validacao {
	
	ObjectMapper mapper = new ObjectMapper();
	
	final static Log log = LogFactory.getLog(Validacao.class);
	
	public void validarConsulta(TipoConsulta consulta, Response response, String id) throws Exception{
		if(response.getStatusCode() == 200){
			String body = response.getBody().asString();
			JsonNode corpo = mapper.readTree(body);
			if(corpo.get("id").asText().equals(id)){
				log.info("Consulta de "+consulta.getOpcao()+" por id efetuada com sucesso! Id consultado: ["+id+"], Id retornado: ["+corpo.get("id").asText()+"]");
			}else{
				log.info("Erro ao validar id do "+consulta.getOpcao()+"");
				throw new Exception("Erro ao validar id do "+consulta.getOpcao());
			}
		}else{
			log.info("Erro ao validar id do "+consulta.getOpcao());
			throw new Exception("Erro ao validar id do "+consulta.getOpcao());
		}
	}
	
	public void validarCadastro(TipoCadastro cadastro, Response response) throws Exception{
		if(response.getStatusCode() == 200){
			log.info(cadastro.getOpcao()+" cadastrado com sucesso! Status code [200]");
		}else{
			log.info("Erro ao cadastrar " +cadastro.getOpcao()+ ". Status code ["+response.getStatusCode()+"]");
			throw new Exception("Erro ao cadastrar " +cadastro.getOpcao()+ ". Status code ["+response.getStatusCode()+"]");
		}
	}
	
	public void validarCadastroCliente(Response response) throws Exception{
		if(response.getStatusCode() == 200){
			JsonNode corpo = mapper.readTree(response.getBody().toString());
			String msg = corpo.get("message").asText();
				if(msg.equals("ok")){
					log.info("Cliente cadastrado com sucesso!");
				}
		}else{
			log.info("Erro ao cadastrar Pet");
			throw new Exception("Erro ao cadastrar Pet");
		}
	}

	public void validarConsultaCliente(Response response, String nome) throws Exception{
		try{
		if(response.getStatusCode() == 200){
			String body = response.getBody().asString();
			JsonNode corpo = mapper.readTree(body);
			String msg = corpo.get("username").asText();
				if(msg.equals(nome)){
					log.info("Cliente consultado com sucesso!");
				}
		}else{
			log.info("Erro ao cadastrar Pet");
			throw new Exception("Erro ao cadastrar Pet");
		}
		}catch(Exception e){
			log.info("Erro ao cadastrar Pet");
			throw new Exception("Erro ao cadastrar Pet");
		}
	}	
}
