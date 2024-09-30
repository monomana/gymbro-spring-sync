package ar.elolmo.gymbro.resources.dtos;

import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.entities.MembershipType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class MemberDTO {

//    private Integer id;
    @NotNull
    @NotBlank
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateBirth;
    private String gender;
    private String phone;
    private String email;
    private String address;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime joinDate;
    @NotNull(message = "No debe ser nulo")
    private Integer membershipTypeId;
    private String photo;
    private boolean active;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;



    public static MemberDTO convertToDTO(Member member) {
        MemberDTO dto = new MemberDTO();
//        dto.setId(member.getId());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        dto.setDateBirth(member.getDateBirth());
        dto.setGender(member.getGender());
        dto.setPhone(member.getPhone());
        dto.setEmail(member.getEmail());
        dto.setAddress(member.getAddress());
        dto.setJoinDate(member.getJoinDate());
        dto.setMembershipTypeId(member.getMembershipType().getId());
        return dto;
    }

    public Member convertToEntity(Member member) {
//        Member member = new Member();
        BeanUtils.copyProperties(this,member);


        // Assume MembershipType is retrieved separately
        MembershipType membershipType = new MembershipType();
        membershipType.setId(this.membershipTypeId);
        member.setMembershipType(membershipType);
        return member;
    }


    // Getters and setters


//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateOfBirth) {
        this.dateBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getMembershipTypeId() {
        return membershipTypeId;
    }

    public void setMembershipTypeId(Integer membershipTypeId) {
        this.membershipTypeId = membershipTypeId;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}

