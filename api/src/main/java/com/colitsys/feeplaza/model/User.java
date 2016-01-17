package com.colitsys.feeplaza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents User object. User object is used for authentication, authorization and for storing user profile.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = true)
    private String email;
    @Column(unique = true, nullable = true)
    private Long mobile;
    @Column(nullable = false)
    private String password;

    /**
     * Default constructor.
     */
    protected User() {
        // Do not allow clients to create empty User object.
    }

    /**
     * Construct new user object.
     *
     * @param name   User display name.
     * @param email  User email address.
     * @param mobile User mobile number.
     * @param password User password.
     */
    public User(final String name, final String email, final Long mobile, final String password) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("ID = %d, Name = %s, email = %s, mobile = %s", id, name, email, mobile);
    }
}
