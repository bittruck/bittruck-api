package br.com.indepdevbr.config.env;

import java.util.Properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.indepdevbr.config.EProperties;

@Component
@Profile("dev")
public class DevProfile {
	
	public DevProfile() {
		Properties properties = System.getProperties();
		properties.setProperty(EProperties.BITTRUCK_API_HOST.toString(), "https://bittruck-api.herokuapp.com");
		properties.setProperty(EProperties.BITTRUCK_FRONT_END_HOST.toString(), "https://bittruck-api.herokuapp.com");
	}
	
}
