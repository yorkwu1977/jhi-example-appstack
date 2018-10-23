package com.mycompany.appstack.client;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import feign.RequestInterceptor;

public class OAuth2InterceptedFeignConfiguration {

//    private final LoadBalancedResourceDetails loadBalancedResourceDetails;
//
//    public OAuth2InterceptedFeignConfiguration(LoadBalancedResourceDetails loadBalancedResourceDetails) {
//        this.loadBalancedResourceDetails = loadBalancedResourceDetails;
//    }
//
//    @Bean(name = "oauth2RequestInterceptor")
//    public RequestInterceptor getOAuth2RequestInterceptor() throws IOException {
//        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), loadBalancedResourceDetails);
//    }
    
    @Bean(name = "serviceFeignClientInterceptor")
    public RequestInterceptor getFeignClientInterceptor() throws IOException {
        return new ServiceFeignClientInterceptor();
    }
}
