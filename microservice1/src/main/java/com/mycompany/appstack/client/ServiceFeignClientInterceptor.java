package com.mycompany.appstack.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import com.mycompany.appstack.security.oauth2.ServiceTokenEndpointClient;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class ServiceFeignClientInterceptor implements RequestInterceptor {

	private final Logger log = LoggerFactory.getLogger(ServiceFeignClientInterceptor.class);

	private static final String AUTHORIZATION_HEADER = "Authorization";

	private static final String BEARER_TOKEN_TYPE = "Bearer";

	@Autowired
	private ServiceTokenEndpointClient serviceTokenEndpointClient;

	@Override
	public void apply(RequestTemplate template) {

		OAuth2AccessToken oauthToken = serviceTokenEndpointClient.sendClentCredentialsGrant();
		if (oauthToken != null) {
			template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, oauthToken.getValue()));
		}

	}
}
