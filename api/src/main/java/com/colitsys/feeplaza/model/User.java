package com.colitsys.feeplaza.model;

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
    private String name;
    private String email;
    private Long mobile;

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
     */
    public User(final String name, final String email, final Long mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return String.format("ID = %d, Name = %s, email = %s, mobile = %s", id, name, email, mobile);
    }
}
