package com.pet.store.PetStoreAPI.apoio;

import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeitorMassaDados {
	
	ObjectMapper mapper = new ObjectMapper();
	
	public JsonNode lerJsonMassaDados(String ct) throws IOException, ParseException{
		FileReader fileReader = new FileReader("C:\\Users\\Hp\\Testes\\PetStoreAPI\\src\\test\\java\\com\\pet\\store\\PetStoreAPI\\massadados\\" +ct+".json"); 
		JSONParser parser = new JSONParser();
		Object js = parser.parse(fileReader);
		JsonNode json = mapper.readTree(js.toString());
		fileReader.close();
		
		return json;
	}

}
