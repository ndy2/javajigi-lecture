package net.slipp.myslipp;

import lombok.RequiredArgsConstructor;
import net.slipp.myslipp.domain.entity.Member;
import net.slipp.myslipp.web.form.MemberForm;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit(){
            Member member = createMember("ndy2", "1234", "ndy", "ndy@gamil.com");
            em.persist(member);
        }

        private Member createMember(String userId, String password, String userName, String email) {
            MemberForm memberForm = new MemberForm();
            memberForm.setUserId(userId);
            memberForm.setPassword(password);
            memberForm.setUserName(userName);
            memberForm.setEmail(email);
            Member member = Member.createUser(memberForm);
            return member;
        }
    }
}
