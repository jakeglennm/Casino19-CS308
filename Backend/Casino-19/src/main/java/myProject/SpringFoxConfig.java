package myProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;

// examples in https://git.linux.iastate.edu/cs309/springboot_tutorials/blob/inClass/inClass/src/main/java/myProject/SpringFoxConfig.java


@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("myProject"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Casino-19 Springboot Database")
				.description("Hi, welcome to the backend of the ComS309 project Casino-19, here is the API document!")
				//.termsOfServiceUrl("https://coms-402-sd-8.cs.iastate.edu:8080/terms")
				//.contact(new Contact("YizhenXu","https://github.com/519045752/ComS402C_SD3","yizhenx@iastate.edu"))
				.version("0.0.1")
				.build();
	}

}
