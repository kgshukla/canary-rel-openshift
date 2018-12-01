package com.example.frontendmain.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontendMainController {

	@Value("${HOSTNAME:local}")
	private String podName; 
	
	@Value("${backendmain.url:http://localhost:8080}")
	private String backendmainURL;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello () {
		String frontendMsg = "FrontendMain-v1: served by pod - " + podName + "!";
		System.out.println(frontendMsg);
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(backendmainURL, String.class);
	     
	    System.out.println(result);
	    String combinedMsg = frontendMsg +" :::: " + result;
		return combinedMsg;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String helloUser(
	  @PathVariable("id") String id) {
		String frontendMsg = "FrontendMain-v1: "+id+ " served by pod - " + podName + "!";
		System.out.println(frontendMsg);
		RestTemplate restTemplate = new RestTemplate();
		String updatedbackendMainURL = backendmainURL.concat("/user/").concat(id);
	    String result = restTemplate.getForObject(updatedbackendMainURL, String.class);
	     
	    System.out.println(result);
		return result;
	}
	
}
