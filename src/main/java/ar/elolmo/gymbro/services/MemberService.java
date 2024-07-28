package ar.elolmo.gymbro.services;

import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Member> findById(Integer id) {
        logger.info("Fetching member with id: {}", id);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return repository.findById(id);
    }

    public Optional<Member> save(Member Member) {
        logger.info("Saving member: {}", Member);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        return Optional.of(repository.save(Member));
    }

    public void deleteById(Integer id) {
        logger.info("Deleting member with id: {}", id);
        logger.info("{}::{} execution start", this.getClass().getSimpleName(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        repository.deleteById(id);
    }
    
   }
