package com.company.singleresp_ex.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.company.singleresp_ex.dto.WorldTimeResponseDTO;
import com.company.singleresp_ex.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

//Receives requests related to order processing
public class OrderController {

    private static final Map<Long, Order> ORDERS = new HashMap<>();

    private static final String TIME_API_URL = "http://worldtimeapi.org/api/ip";

    //Receives request for new order creation
    public String createOrder(String request) {

        ObjectMapper mapper = new ObjectMapper();
        Order order;
        try {
            order = mapper.readValue(request, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
        WorldTimeResponseDTO timeDto = getTime();
        order.setCreatedOn(timeDto.getUnixtime());        
        order.setLastUpdatedOn(timeDto.getUnixtime());
        synchronized(ORDERS) {
            ORDERS.put(order.getOrderId(), order);
        }
        return "OK";
    }

    public Order getOrder(Long orderId) {
    	synchronized(ORDERS) {
    		return ORDERS.get(orderId);
    	}
    }
    
    private WorldTimeResponseDTO getTime() {
        ObjectMapper mapper = new ObjectMapper();
        WorldTimeResponseDTO timeResponseDTO;
        
        HttpGet get = new HttpGet(TIME_API_URL);
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault(); 
        	 CloseableHttpResponse timeResponse = httpClient.execute(get)){
            timeResponseDTO = mapper.readValue(EntityUtils.toString(timeResponse.getEntity()), WorldTimeResponseDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return timeResponseDTO;
    }
}