package ar.elolmo.gymbro.resources.dtos;

import ar.elolmo.gymbro.entities.Member;
import ar.elolmo.gymbro.entities.MembershipType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;

public class MemberInDTO {

    private Integer id;
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
    private Integer membershipTypeId;

    public static MemberInDTO convertToDTO(Member member) {
        MemberInDTO dto = new MemberInDTO();
        dto.setId(member.getId());
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

    public Member convertToEntity() {
        Member member = new Member();
        BeanUtils.copyProperties(this,member);
//        member.setId(dto.getId());
//        member.setFirstName(dto.getFirstName());
//        member.setLastName(dto.getLastName());
//        member.setDateBirth(dto.getDateBirth());
//        member.setGender(dto.getGender());
//        member.setPhone(dto.getPhone());
//        member.setEmail(dto.getEmail());
//        member.setAddress(dto.getAddress());
//        member.setJoinDate(dto.getJoinDate());

        // Assume MembershipType is retrieved separately
        MembershipType membershipType = new MembershipType();
        membershipType.setId(this.membershipTypeId);
        member.setMembershipType(membershipType);
        return member;
    }


    // Getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}

