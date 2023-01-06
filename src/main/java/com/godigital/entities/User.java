package com.godigital.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_details")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name = "username")
    private String userName;
    @Column(name = "mobile")
    private long userPhoneNumber;
    @Column(name = "email")
    private String email;

    private Date createdOn;
    private Date changedOn;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private UserPersonal userPersonal;

    @JsonProperty
    public Date getCreatedOn() {
        return createdOn;
    }

    @JsonIgnore
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty
    public Date getChangedOn() {
        return changedOn;
    }

    @JsonIgnore
    public void setChangedOn(Date changedOn) {
        this.changedOn = changedOn;
    }
}
