package br.com.indepdevbr.config;

import org.springframework.stereotype.Component;

@Component
public class GeneralProperties {
	
	public String getPropertyValue(EProperties propertyName) {		
		return System.getProperty(propertyName.toString());
	}
	
}
