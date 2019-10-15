package com.douglaz.system.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	//org.slf4j.Logger logger = LoggerFactory.getLogger(Hello.class);
	 Logger logger = LoggerFactory.getLogger(Hello.class);
	 
	@GetMapping("/hello")
	public String get() throws UnknownHostException {
		
		logger.trace("Acesso aos dados  - SERVER {0}", InetAddress.getLocalHost().getHostAddress());
		logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
		return "get data server " + InetAddress.getLocalHost().getHostAddress();
	}

}
