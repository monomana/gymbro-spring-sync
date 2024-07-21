package ar.elolmo.gymbro.resources;


import ar.elolmo.gymbro.entities.MembershipType;
import ar.elolmo.gymbro.services.MembershipTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "membership-types")
public class MembershipTypeResource {

    private final MembershipTypeService membershipTypeService;

    public MembershipTypeResource(MembershipTypeService membershipTypeService) {
        this.membershipTypeService = membershipTypeService;
    }

    @GetMapping()
    public List<MembershipType> getMembershipTypes(){
        return membershipTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipType> getMembershipTypeById(@PathVariable Integer id) {
        return membershipTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping()
    public ResponseEntity<String> createMembershipTypes(@RequestBody MembershipType membershipType){
        membershipTypeService.save(membershipType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipType> updateMembershipType(@PathVariable Integer id, @RequestBody MembershipType membershipTypeDetails) {
        return membershipTypeService.findById(id)
                .map(existingMembershipType -> {
                    existingMembershipType.setName(membershipTypeDetails.getName());
                    existingMembershipType.setDurationMonths(membershipTypeDetails.getDurationMonths());
                    existingMembershipType.setPrice(membershipTypeDetails.getPrice());
                    return ResponseEntity.ok(membershipTypeService.save(existingMembershipType));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembershipType(@PathVariable Integer id) {
        if (membershipTypeService.findById(id).isPresent()) {
            membershipTypeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
