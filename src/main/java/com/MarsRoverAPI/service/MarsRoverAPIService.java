package com.MarsRoverAPI.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MarsRoverAPI.response.MarsRoverApiResponse;

@Service
public class MarsRoverAPIService {

	public MarsRoverApiResponse getRoverData() {
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY", 
				MarsRoverApiResponse.class);
		
		return response.getBody();
	}
}
