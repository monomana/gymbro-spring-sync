package ar.elolmo.gymbro.resources;


import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.entities.MembershipType;
import ar.elolmo.gymbro.resources.dtos.MemberInDTO;
import ar.elolmo.gymbro.resources.dtos.MemberOutDTO;
import ar.elolmo.gymbro.services.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;

@CrossOrigin(origins="http://localhost:4200")
    @RestController
    @RequestMapping("/api/members")
    public class MemberResource {

        @Autowired
        private MemberService service;

    private static final Logger logger = LoggerFactory.getLogger(MemberResource.class);

    @GetMapping(value = "page")
    public ResponseEntity<Page<MemberOutDTO>>
    getAllMembers(Pageable pageable,
//                  @RequestParam(defaultValue = "fistName", required = false) String filterField,
                  @RequestParam(defaultValue = "fistName", required = false) String[] filterFields,
                  @RequestParam( required = false) String filterText) {

        Specification<Member> spec = Specification.where(null);
        for (int i=0;i < filterFields.length ;i++) {
            var filterField =filterFields[i];

//            logger.info("Fetching all Member",filterField+""+filterFields,"length ",filterFields.length);
            spec = spec.or((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get(filterField).as(String.class), "%" + filterText + "%"));
        }
//        if (filterField != null) {
//            spec = spec.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.like(root.get(filterField), "%" + filterText + "%"));
//        }
        Page<MemberOutDTO> members = service.findAll(spec,pageable).map(MemberOutDTO::convertToDTO);
        return ResponseEntity.ok(members);
    }

        @GetMapping
        public List<MemberOutDTO> getAllMember() {

            logger.info("Request to get all members");
            return service.findAll().stream().map(MemberOutDTO::convertToDTO).collect(Collectors.toList());

        }


        // TODO: cambiar los metodos que siguen por el ejemplo de chatgpt
        @GetMapping("/{id}")
        public ResponseEntity<Member> getMemberById(@PathVariable @Valid Integer id) {
            return service.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public MemberOutDTO createMember(@RequestBody @Valid MemberInDTO memberInDTO) {
            return service.save(memberInDTO).map(MemberOutDTO::convertToDTO).orElseThrow();
        }

        // TODO: uncoment dates fields
        @PutMapping("/{id}")
        public ResponseEntity<?> updateMember(@PathVariable @Valid Integer id,
                                              @RequestBody @Valid MemberInDTO memberDetails) {
            return ResponseEntity.ok(service.updateMember(id,memberDetails));
//            return service.findById(id)
////                    .map(existingMember -> memberDetails::convertToEntity)
//                    .map(existingMember -> {
//                        existingMember.setFirstName(memberDetails.getFirstName());
//                        existingMember.setLastName(memberDetails.getLastName());
//                        existingMember.setDateBirth(memberDetails.getDateBirth());
//                        existingMember.setGender(memberDetails.getGender());
//                        existingMember.setPhone(memberDetails.getPhone());
//                        existingMember.setEmail(memberDetails.getEmail());
//                        existingMember.setAddress(memberDetails.getAddress());
//                        existingMember.setJoinDate(memberDetails.getJoinDate());
//                        existingMember.setActive(memberDetails.isActive());
//                        MembershipType membershipType = new MembershipType();
//                        membershipType.setId(memberDetails.getMembershipTypeId());
//                        existingMember.setMembershipType(membershipType);
//                        return ResponseEntity.ok(service.save(existingMember).get());
//                    })
//                    .orElse(ResponseEntity.notFound().build());
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

