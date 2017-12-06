package cn.biga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 */
@Controller
public class HtmlController {
    @RequestMapping(value = {"/index","/"})
    public String index(){
        return "index";
    }

    @RequestMapping("/home")
    public String securedPage(){
        return "home";
    }
}
