package com.xjb_villager.lifei.config.swagger;
/**
 * <pre>
 *   通过SwaggerConfig配置来进行前端调试访问
 * </pre>
 *
 * @param
 * @return
 * @author xjs
 * created by  2021年02月01日08:12:06
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket creatDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.xjb_villager.controller"))
                .paths(PathSelectors.any()).build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("薛家堡村测试接口")
                .description("API的调用")
                .termsOfServiceUrl("no term url")
                .version("1.0")
                .build();
    }

}
