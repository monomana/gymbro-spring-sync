package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.MembershipType;
import ar.elolmo.gymbro.repository.MembershipTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeService {
    private final MembershipTypeRepository membershipTypeRepository;

    public MembershipTypeService(MembershipTypeRepository membershipTypeRepository) {
        this.membershipTypeRepository = membershipTypeRepository;
    }

    public List<MembershipType> findAll(){
        return membershipTypeRepository.findAll();
    }

    public Optional<MembershipType> findById(Integer id) {
        return membershipTypeRepository.findById(id);
    }

    public MembershipType save(MembershipType membershipType) {
        return membershipTypeRepository.save(membershipType);
    }

    public void deleteById(Integer id) {
        membershipTypeRepository.deleteById(id);
    }

}
