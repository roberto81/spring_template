package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.util.Objects;

public class ContactDTO {

    private Integer id;
    private String email;
    private String primaryPhoneNumber;
    private String secondarySecondaryNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public String getSecondarySecondaryNumber() {
        return secondarySecondaryNumber;
    }

    public void setSecondarySecondaryNumber(String secondarySecondaryNumber) {
        this.secondarySecondaryNumber = secondarySecondaryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDTO that = (ContactDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(primaryPhoneNumber, that.primaryPhoneNumber) &&
                Objects.equals(secondarySecondaryNumber, that.secondarySecondaryNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, primaryPhoneNumber, secondarySecondaryNumber);
    }
}
