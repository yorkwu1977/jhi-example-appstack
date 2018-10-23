package com.mycompany.appstack.client.feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.appstack.client.AuthorizedFeignClient;

@AuthorizedFeignClient(name = "uaa", fallback = CallUaaAuthFeignClientHystrix.class)
public interface CallUaaAuthFeignClient {

    @RequestMapping(value = "/api/provider", method = RequestMethod.GET)
    String callProvider();
}
