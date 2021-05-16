package com.pet.store.PetStoreAPI.func;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.pet.store.PetStoreAPI.apoio.LeitorMassaDados;

public class MassaDados {

	ObjectMapper mapper = new ObjectMapper();

	private String id;
	private String name;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String userStatus;
	private String categoriaPet;
	private String status;
	private String petID;
	private String cliente;
	private String nomePet;

	public MassaDados(String tipo, String ct) throws JsonProcessingException, FileNotFoundException, IOException {
		try {
			
			LeitorMassaDados leitorMassaDados = new LeitorMassaDados();
			JsonNode json = leitorMassaDados.lerJsonMassaDados(ct);
			
			
			switch (tipo) {
			case "pet":

				nomePet = json.get("nomePet").asText();
				categoriaPet = json.get("categoriaPet").asText();
				status = json.get("status").asText();
				petID = json.get("petID").asText();

				break;
			case "cliente":

				id = json.get("id").asText();
				name = json.get("username").asText();
				firstName = json.get("firstName").asText();
				lastName = json.get("lastName").asText();
				email = json.get("email").asText();
				password = json.get("password").asText();
				phone = json.get("phone").asText();
				userStatus = json.get("userStatus").asText();

				break;
			case "venda":

				id = json.get("id").asText();
				status = json.get("status").asText();
				petID = json.get("petID").asText();
				cliente = json.get("cliente").asText();
				break;
			}
		} catch (Exception e) {
			System.out.print("erro");
		}
	}

	public MassaDados(String tipo, String ct, int index) throws JsonProcessingException, FileNotFoundException, IOException {
		try {
			
			LeitorMassaDados leitorMassaDados = new LeitorMassaDados();
			JsonNode json = leitorMassaDados.lerJsonMassaDados(ct);
			
			if(json.toString().contains("data")){
				json = json.get("data");
				json = json.get(index);
			}
			
			switch (tipo) {
			case "pet":

				nomePet = json.get("nomePet").asText();
				categoriaPet = json.get("categoriaPet").asText();
				status = json.get("status").asText();
				petID = json.get("petID").asText();

				break;
			case "cliente":

				id = json.get("id").asText();
				name = json.get("username").asText();
				firstName = json.get("firstName").asText();
				lastName = json.get("lastName").asText();
				email = json.get("email").asText();
				password = json.get("password").asText();
				phone = json.get("phone").asText();
				userStatus = json.get("userStatus").asText();

				break;
			case "venda":

				id = json.get("id").asText();
				status = json.get("status").asText();
				petID = json.get("petID").asText();
				cliente = json.get("cliente").asText();
				break;
			}
		} catch (Exception e) {
			System.out.print("erro");
		}
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public String getCategoriaPet() {
		return categoriaPet;
	}

	public String getStatus() {
		return status;
	}

	public String getPetID() {
		return petID;
	}

	public String getCliente() {
		return cliente;
	}

	public String getNomePet() {
		return nomePet;
	}

}
