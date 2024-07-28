package ar.elolmo.gymbro.resources;


import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.resources.dtos.MemberInDTO;
import ar.elolmo.gymbro.resources.dtos.MemberOutDTO;
import ar.elolmo.gymbro.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


    @RestController
    @RequestMapping("/api/members")
    public class MemberResource {

        @Autowired
        private MemberService service;

        private static final Logger logger = LoggerFactory.getLogger(MemberResource.class);

        @GetMapping
        public List<MemberOutDTO> getAllMember() {

            logger.info("Request to get all members");
            return service.findAll().stream().map(MemberOutDTO::convertToDTO).collect(Collectors.toList());

        }

        // TODO: cambiar los metodos que siguen por el ejemplo de chatgpt
        @GetMapping("/{id}")
        public ResponseEntity<Member> getMemberById(@PathVariable Integer id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public MemberOutDTO createMember(@RequestBody MemberInDTO member) {

            return service.save(member.convertToEntity()).map(MemberOutDTO::convertToDTO).get();
        }

        // TODO: uncoment dates fields
        @PutMapping("/{id}")
        public ResponseEntity<Member> updateMember(@PathVariable Integer id, @RequestBody MemberInDTO memberDetails) {
            return service.findById(id)
//                    .map(existingMember -> memberDetails::convertToEntity)
                    .map(existingMember -> {
                        existingMember.setFirstName(memberDetails.getFirstName());
                        existingMember.setLastName(memberDetails.getLastName());
                        existingMember.setDateBirth(memberDetails.getDateBirth());
                        existingMember.setGender(memberDetails.getGender());
                        existingMember.setPhone(memberDetails.getPhone());
                        existingMember.setEmail(memberDetails.getEmail());
                        existingMember.setAddress(memberDetails.getAddress());
                        existingMember.setJoinDate(memberDetails.getJoinDate());
//                        existingMember.setMemberhipType(memberDetails.getMemberhipType());
                        return ResponseEntity.ok(service.save(existingMember).get());
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

