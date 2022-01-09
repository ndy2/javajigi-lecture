package net.slipp.myslipp.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.slipp.myslipp.domain.entity.Member;
import net.slipp.myslipp.domain.service.MemberService;
import net.slipp.myslipp.web.form.MemberEditForm;
import net.slipp.myslipp.web.form.MemberForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
       if(result.hasErrors()){
            log.info("[signIn] validation logic");
            return "user/form";
        }

        memberService.join(memberForm);
        return "redirect:/";
    }

    @GetMapping("/user/list")
    public String list(Model model){
        List<Member> members = memberService.findAll();

        model.addAttribute("members",members);
        System.out.println("members = " + members.size());
        for (Member member : members) {
            System.out.println("member = " + member);
        }
        return "user/list";
    }

    @GetMapping("/user/login")
    public String loginForm(){
        return "user/login";
    }

    @PostMapping("/user/login")
    public String login(
            @RequestParam String userId,
            @RequestParam String password,
            Model model,
            HttpSession session
    ){
        if (!memberService.authenticate(userId, password)) {
            //로그인 실패
            model.addAttribute("loginError","loginError");
            return "/user/login";
        }
        //성공 로직
        Long id = memberService.findIdByUserId(userId);
        session.setAttribute("user",id);

        return "redirect:/";
    }

    @GetMapping("/user/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        Member member = memberService.findById(id);

        model.addAttribute("member", member);
        return "user/edit";
    }

    @PostMapping("/user/edit/{id}")
    public String edit(@PathVariable Long id,
                       MemberEditForm memberEditForm){

        memberService.edit(id, memberEditForm);

        return "redirect:/user/list";
    }



}
