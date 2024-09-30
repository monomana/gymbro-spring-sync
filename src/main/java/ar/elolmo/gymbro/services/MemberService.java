package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.repository.MemberRepository;
import ar.elolmo.gymbro.resources.dtos.MemberInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    public List<Member> findAll() {
        logger.info("Fetching all Member");
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return repository.findAll();
    }

    public Page<Member> findAll(Specification<Member> spec, Pageable pageable) {
        logger.info("Fetching all Member");
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return repository.findAll(spec,pageable);
    }

    public Optional<Member> findById(Integer id) {
        logger.info("Fetching member with id: {}", id);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return repository.findById(id);
    }
    public Optional<Member> updateMember(Integer id, MemberInDTO memberInDTO) {
        Member member = findById(id).orElseThrow();
        member = findById(id).map(memberInDTO::convertToEntity).orElseThrow();
        logger.info("Saving member: {}", member);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return Optional.of(repository.save(member));
    }

    public Optional<Member> save(MemberInDTO memberInDTO) {
        logger.info("Saving member: {}", memberInDTO);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        Member member = new Member();

        return Optional.of(repository.save(
                Optional.of(member)
                        .map(memberInDTO::convertToEntity)
                        .orElseThrow()
                ));
    }

    public void deleteById(Integer id) {
        logger.info("Deleting member with id: {}", id);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        repository.deleteById(id);
    }
    
   }
