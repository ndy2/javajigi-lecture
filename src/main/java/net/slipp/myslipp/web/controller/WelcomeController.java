package net.slipp.myslipp.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class WelcomeController {


    @GetMapping({"/", "/index"})
    public String home(){
        return "index";
    }

}
