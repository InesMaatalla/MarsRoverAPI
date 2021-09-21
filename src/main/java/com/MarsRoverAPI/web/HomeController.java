package com.MarsRoverAPI.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.MarsRoverAPIdto.HomeDto;
import com.MarsRoverAPI.response.MarsRoverApiResponse;
import com.MarsRoverAPI.service.MarsRoverApiService;

public class HomeController {

	  @Autowired
	  private MarsRoverApiService roverService;
	  
	  @GetMapping("/")
	  public String getHomeView (ModelMap model, HomeDto homeDto) {
	    if (homeDto.getMarsApiRoverData() != null) {
	      homeDto.setMarsApiRoverData("Opportunity");
	    }
	    if (homeDto.getMarsSol() == null)
	      homeDto.setMarsSol(1);
	    
	    MarsRoverApiResponse roverData = roverService.getRoverData(homeDto.getMarsApiRoverData(), homeDto.getMarsSol());
	    model.put("roverData", roverData);
	    model.put("homeDto", homeDto);
	    
	    return "index";
	  }

}
