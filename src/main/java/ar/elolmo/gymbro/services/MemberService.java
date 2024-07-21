package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Optional<Member> findById(Integer id) {
        return repository.findById(id);
    }

    public Member save(Member Member) {
        return repository.save(Member);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
