package pl.codecity.employees.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Swagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.codecity"))
                .paths(regex("/user.*"))
                .build()
                .apiInfo(metadata());
    }

    //@Bean
    public Docket assetApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.codecity"))
                .paths(regex("/asset.*"))
                .build()
                .apiInfo(metadata());
    }

    private ApiInfo metadata(){
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("\"Spring Boot REST API for GDPR Application\"")
                .version("2.0.1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
