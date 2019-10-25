package br.com.indepdevbr.config.env;

import java.util.Properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.indepdevbr.config.EProperties;

@Component
@Profile("local")
public class LocalProfile {
	
	public LocalProfile() {
		Properties properties = System.getProperties();
		properties.setProperty(EProperties.BITTRUCK_API_HOST.toString(), "http://localhost:8080");
		properties.setProperty(EProperties.BITTRUCK_FRONT_END_HOST.toString(), "http://localhost:8080");
	}
	
}
