package net.slipp.myslipp.domain.entity;

import lombok.Getter;
import net.slipp.myslipp.web.form.MemberEditForm;
import net.slipp.myslipp.web.form.MemberForm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String userName;

    private String password;

    private String email;

    public static Member createUser(MemberForm form){
        Member member = new Member();
        member.userId = form.getUserId();
        member.userName = form.getUserName();
        member.password = form.getPassword();
        member.email = form.getEmail();
        return member;
    }

    public void editMember(MemberEditForm editMember){
        this.userName = editMember.getUserName();
        this.password=editMember.getPassword();
        this.email=editMember.getEmail();
    }
}
