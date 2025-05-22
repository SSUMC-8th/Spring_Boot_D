package umc.spring.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}