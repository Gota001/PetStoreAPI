package com.pet.store.PetStoreAPI.apoio;

import com.pet.store.PetStoreAPI.func.MassaDados;

public class RestAuxiliar {
	
	public static String bodyCadastroClente(MassaDados massa){
		String body = "[{"+
						"\"id\": "+massa.getId()+","+
						"\"username\": \""+massa.getName()+"\","+
						"\"firstName\": \""+massa.getFirstName()+"\","+
						"\"lastName\": \""+massa.getLastName()+"\","+
						"\"email\": \""+massa.getEmail()+"\","+
						"\"password\": \""+massa.getPassword()+"\","+
						"\"phone\": \""+massa.getPhone()+"\","+
						"\"userStatus\": 0"+
						"}]";
		return body;
	}

	public static String bodyCadastroPet(MassaDados massa){
		String body = "{"+
					    "\"id\": "+massa.getPetID()+","+
					    "\"category\": {"+
					     	"\"id\": "+massa.getPetID()+","+
					        "\"name\": \""+massa.getCategoriaPet()+"\""+
					        "},"+
					    "\"name\": \""+massa.getNomePet()+"\","+
					    "\"photoUrls\": ["+
					        "\"string\""+
					    "],"+
					    "\"tags\": ["+
					        "{"+
					            "\"id\": "+massa.getPetID()+","+
					            "\"name\": \""+massa.getNomePet()+"\""+
					        "}"+
					    "],"+
					    "\"status\": \""+massa.getStatus()+"\""+
					"}";
		return body;
	}
	
	public static String bodyCadastroVenda(MassaDados massa){
		String body = "{"+
					  "\"id\": "+massa.getId()+","+
					  "\"petId\": "+massa.getPetID()+","+
					  "\"quantity\": 1,"+
					  "\"shipDate\": \"2021-05-11T00:44:48.450Z\","+
					  "\"status\": \""+massa.getStatus()+"\","+
					  "\"user\": \""+massa.getCliente()+"\","+ 
					  "\"complete\": true"+
					  "}";
		return body;
	}
}
