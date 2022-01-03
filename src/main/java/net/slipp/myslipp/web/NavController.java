package net.slipp.myslipp.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class NavController {


    @GetMapping("/")
    public String home(){
        return "/index";
    }

    @GetMapping("/form")
    public String signIn(){
        return "/form";
    }

    @GetMapping("/list")
    public String list(){
        return "/list";
    }
}
