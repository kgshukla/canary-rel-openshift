package com.example.backendmain.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendMainController {

	@Value("${HOSTNAME:local}")
	private String podName; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello () {
		String mesg = "BackendMain-v1: Hello from pod - " + podName + "!";
		System.out.println(mesg);
		return mesg;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String helloUser(
	  @PathVariable("id") String id) {
		String mesg = "BackendMain-v1: Hello, "+id+", from pod - " + podName +"!";
		System.out.println(mesg);
		return mesg;
	}
}
