package com.douglaz.system.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping("/")
	public String get() throws UnknownHostException {
		
		Logger.getLogger(Hello.class.getName()).log(Level.SEVERE, "Acesso aos dados  - SERVER {0}", InetAddress.getLocalHost().getHostAddress());
		return "get data server " + InetAddress.getLocalHost().getHostAddress();
	}

}
