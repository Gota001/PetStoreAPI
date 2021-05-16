package com.pet.store.PetStoreAPI.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pet.store.PetStoreAPI.apoio.RestAuxiliar;
import com.pet.store.PetStoreAPI.func.MassaDados;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStoreAPI {

	
	final static Log log = LogFactory.getLog(PetStoreAPI.class);
	
	public Response cadastrarCliente(MassaDados massa){
		try{
			String endereco = "https://petstore.swagger.io/v2/user/createWithArray";
			log.info("Cadastro de cliente - "+ endereco);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation().
			header("Content-Type", "application/json").
			body(RestAuxiliar.bodyCadastroClente(massa));
			
			Response response = spec.post(endereco);
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public Response consultarCliente(String nomeCliente){
		try{
			
			String endereco = "https://petstore.swagger.io/v2/user/"+nomeCliente;
			log.info("Consulta por cliente - "+ endereco);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation();
			
			Response response = spec.get(endereco);
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public Response cadastrarPet(MassaDados massa){
		try{
			
			String endereco = "https://petstore.swagger.io/v2/pet";
			log.info("Cadastro de Pet - "+ endereco);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation().
			header("Content-Type", "application/json").
			body(RestAuxiliar.bodyCadastroPet(massa));
			
			Response response = spec.post(endereco);
			
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public Response consultarPet(String idPet){
		try{
			
			String endereco = "https://petstore.swagger.io/v2/pet/"+idPet;
			log.info("Consulta de Pet - "+ endereco);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation();
			
			Response response = spec.get(endereco);
			
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public Response efetuarVendaPet(MassaDados massa){
		try{
			
			String endereco = "https://petstore.swagger.io/v2/store/order";
			log.info("Venda de Pet - "+ endereco);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation().
			header("Content-Type", "application/json").
			body(RestAuxiliar.bodyCadastroVenda(massa));
			
			Response response = spec.post(endereco);
			
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public Response consultarVenda(String idVenda){
		try{
			
			String endereco = "https://petstore.swagger.io/v2/store/order/"+idVenda;
			log.info("Consultar Venda de Pet - "+ endereco);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation();
			
			Response response = spec.get(endereco);
			
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
}
