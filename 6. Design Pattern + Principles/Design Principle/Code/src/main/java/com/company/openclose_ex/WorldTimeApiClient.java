package com.company.openclose_ex;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.company.singleresp_ex.dto.WorldTimeResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WorldTimeApiClient {

	private static final String URL = "http://worldtimeapi.org/api/timezone/UTC";
	
	public long getCurrentUnixtimeUTC() {
		
		HttpGet get = new HttpGet(URL);
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); 
        	 CloseableHttpResponse timeResponse = httpClient.execute(get)) {
        	
        	String response = EntityUtils.toString(timeResponse.getEntity());
        	
        	ObjectMapper mapper = new ObjectMapper();
    		WorldTimeResponseDTO timeResponseDTO;
    		
    		timeResponseDTO = mapper.readValue(response, WorldTimeResponseDTO.class);
            return timeResponseDTO.getUnixtime();
            
        } catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
