package com.mycompany.appstack.web.rest;

import com.mycompany.appstack.client.feign.CallUaaAuthFeignClient;
import com.mycompany.appstack.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for Test AuthFeignClient.
 */
@RestController
@RequestMapping("/test")
public class CallUaaResource {

    private final Logger log = LoggerFactory.getLogger(CallUaaResource.class);

    @Autowired
	private CallUaaAuthFeignClient callUaaAuthFeignClient;
    
    public CallUaaResource(RoleService roleService) {
    
    }   

    /**
     * GET  /servicecall :
     * 
     * @return 
     */
    @GetMapping("/servicecall")
    public String getProvider() {
        log.debug("REST request to get provider from uaa.");
        return callUaaAuthFeignClient.callProvider();
    }

}
