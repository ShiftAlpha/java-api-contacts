package com.acoer.test.contact;

//imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan
public class Application {

	
	@Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        // return ValidatingMongoEventListener(validator());
		return null;
    }

	@Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
