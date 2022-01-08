package net.slipp.myslipp.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.slipp.myslipp.domain.entity.Member;
import net.slipp.myslipp.domain.service.MemberService;
import net.slipp.myslipp.web.form.MemberForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/user/form")
    public String signInForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "user/form";
    }

    @PostMapping("/user/form")
    public String signIn(@Validated MemberForm memberForm, BindingResult result){
        System.out.println("memberForm = " + memberForm);
        System.out.println("result = " + result);
        if(result.hasErrors()){
            log.error("[signIn] validation logic");
            System.out.println("result = " + result);
            return "user/form";
        }

        memberService.join(memberForm);
        return "redirect:/";
    }

    @GetMapping("/user/list")
    public String list(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);

        return "user/list";
    }

    @GetMapping("/user/login")
    public String login(Model model){

        return "user/login";
    }

}
