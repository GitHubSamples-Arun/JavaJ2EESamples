package com.springbootangular.userportal.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_portal")
public class User {

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ")
    @Column
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
