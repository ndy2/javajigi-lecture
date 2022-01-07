package net.slipp.myslipp.domain.entity;

import lombok.Getter;
import net.slipp.myslipp.web.form.MemberForm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    private String userName;

    private String password;

    private String email;

    public static Member createUser(MemberForm form){
        Member member = new Member();
        member.loginId = form.getLoginId();
        member.userName = form.getUserName();
        member.password = form.getPassword();
        member.email = form.getEmail();
        return member;
    }
}
