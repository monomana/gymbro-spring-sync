package ar.elolmo.gymbro.repository;

import ar.elolmo.gymbro.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer>, JpaSpecificationExecutor<Member> {
}
