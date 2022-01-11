package net.slipp.myslipp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnAController {

    @GetMapping("qna/form")
    public String QnaForm(){
        return "qna/form";
    }

    @GetMapping("qna/show")
    public String QnaShow(){
        return "qna/show";
    }
}
