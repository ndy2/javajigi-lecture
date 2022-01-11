package net.slipp.myslipp.domain.repository;

import net.slipp.myslipp.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);
}
