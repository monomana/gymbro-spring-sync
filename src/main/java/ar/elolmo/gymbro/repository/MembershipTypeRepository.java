package ar.elolmo.gymbro.repository;

import ar.elolmo.gymbro.entities.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType,Integer> {

}


