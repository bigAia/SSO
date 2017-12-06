package cn.biga.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @RequestMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
}
