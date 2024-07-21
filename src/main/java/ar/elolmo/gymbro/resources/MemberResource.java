package ar.elolmo.gymbro.resources;


import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/Member")
    public class MemberResource {

        @Autowired
        private MemberService service;

        @GetMapping
        public List<Member> getAllMember() {
            return service.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Member> getMemberById(@PathVariable Integer id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public Member createMember(@RequestBody Member Member) {
            return service.save(Member);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Member> updateMember(@PathVariable Integer id, @RequestBody Member memberDetails) {
            return service.findById(id)
                    .map(existingMember -> {
                        existingMember.setFirstName(memberDetails.getFirstName());
                        existingMember.setLastName(memberDetails.getLastName());
                        existingMember.setDateOfBirth(memberDetails.getDateOfBirth());
                        existingMember.setGender(memberDetails.getGender());
                        existingMember.setPhone(memberDetails.getPhone());
                        existingMember.setEmail(memberDetails.getEmail());
                        existingMember.setAddress(memberDetails.getAddress());
                        existingMember.setJoinDate(memberDetails.getJoinDate());
                      //  existingMember.setMemberhipType(memberDetails.getMemberhipType());
                        return ResponseEntity.ok(service.save(existingMember));
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMember(@PathVariable Integer id) {
            if (service.findById(id).isPresent()) {
                service.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }

