package com.mycompany.appstack.web.rest;

import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api")
public class ProviderResource {

    public ProviderResource () {

    }
    
    /**
     * GET  /provider:
     */
    @GetMapping("/provider")
    public String provider() {
        return "Hello, I'm uaa provider.";
    }
    
}