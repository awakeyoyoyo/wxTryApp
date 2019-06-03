package com.awakeyoyoyo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //Loads the spring beans required by the framework
public class SwaggerConfig {
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.awakeyoyoyo.controller.protal")) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监�?
                .build();
    }
    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "SpringMVC REST API文档:http://localhost:8080/wxTrpApp/swagger-ui.html",
                "使用Swagger UI构建SpringMVC REST风格的可视化文档",
                "1.0.0-SNAPSHOT",
                "http://localhost:8080/wxTrpApp/v2/api-docs",
                "clocm",
                "Apache License",
                "http://www.apache.org/licenses/LICENSE-2.0.html");

        return apiInfo;
    }

}
