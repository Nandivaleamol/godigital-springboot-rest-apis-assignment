package com.godigital.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_personal")
public class UserPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_personal_id")
    private long userPersonalId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;

    private String dob;
    private String gender;
    @Column(name = "aadhar_id")
    private long aadharNo;

    @OneToOne
    @JsonBackReference
    private User user;

}
