package com.mycompany.appstack.client.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CallUaaAuthFeignClientHystrix implements CallUaaAuthFeignClient {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public String callProvider() {
        log.error("调用uaa provider接口失败!");
        return "调用uaa provider接口失败!";
    }

}
