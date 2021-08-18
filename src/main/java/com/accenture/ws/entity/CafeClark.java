package com.accenture.ws.entity;

import org.springframework.stereotype.Component;

@Component
public class CafeClark {
	
	private String name= "Levi";

	
	public CafeClark(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public CafeClark() {
		
	}
}
