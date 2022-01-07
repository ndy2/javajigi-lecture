package net.slipp.myslipp.domain.service;

import lombok.RequiredArgsConstructor;
import net.slipp.myslipp.domain.entity.Member;
import net.slipp.myslipp.domain.repository.MemberRepository;
import net.slipp.myslipp.web.form.MemberForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(MemberForm memberForm) {
        Member member = Member.createUser(memberForm);
        memberRepository.save(member);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

}
