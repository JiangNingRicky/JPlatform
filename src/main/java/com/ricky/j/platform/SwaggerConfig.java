package com.ricky.j.platform;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {

    @Value("${swagger.enabled}")
    private boolean enabled;

    @Value("${server.version}")
    private String version;

    @Bean
    public Docket configSwagger(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getCustomizedApiInfo())
                //配置Swagger-UI是否显示，生产环境不应暴露接口
                .enable(enabled)
                //配置Swagger-UI需要扫描的路径
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ricky.j.platform.web.controller"))
                .build();
    }

    public ApiInfo getCustomizedApiInfo(){
        //Swagger-UI界面相关配置
        return new ApiInfoBuilder().description("")
                .version(version)
                .contact(new Contact("Ricky","https://github.com/JiangNingRicky","jiangning_ricky@163.com")).build();
    }


}
