package net.slipp.myslipp.domain.service;

import lombok.RequiredArgsConstructor;
import net.slipp.myslipp.domain.entity.Member;
import net.slipp.myslipp.domain.repository.MemberRepository;
import net.slipp.myslipp.web.form.MemberEditForm;
import net.slipp.myslipp.web.form.MemberForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void join(MemberForm memberForm) {
        Member member = Member.createUser(memberForm);
        memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).get();
    }

    @Transactional
    public void edit(Long id, MemberEditForm memberEditForm) {
        Member member = memberRepository.findById(id).get();
        member.editMember(memberEditForm);
    }

    public boolean authenticate(String userId, String password) {
        Member member = memberRepository.findByUserId(userId);
        if(member == null){
            return false;
        }
        return isValidPassword(password, member);
    }

    private boolean isValidPassword(String password, Member member) {
        return password.equals(member.getPassword());
    }

    public Member findByUserId(String userId) {
        return memberRepository.findByUserId(userId);
    }
}
