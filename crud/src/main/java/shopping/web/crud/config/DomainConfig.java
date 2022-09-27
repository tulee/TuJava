package shopping.web.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DomainConfig {

	@Bean(name = "RestTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
