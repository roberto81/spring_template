package com.example.demo.entity;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTACT")
@GenericGenerator(
        name = "contactSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "CONTACT_SEQUENCE"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class Contact {

        @Id
        @GeneratedValue(generator = "contactSequenceGenerator")
        private Integer id;
        @Column(name = "email", nullable = false)
        private String email;
        @Column(name = "prmaryPhoneNumber", nullable = false)
        private String primaryPhoneNumber;
        @Column(name = "secondaryPhoneNumber", nullable = true)
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
                Contact contact = (Contact) o;
                return Objects.equals(id, contact.id) &&
                        Objects.equals(email, contact.email) &&
                        Objects.equals(primaryPhoneNumber, contact.primaryPhoneNumber) &&
                        Objects.equals(secondarySecondaryNumber, contact.secondarySecondaryNumber);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, email, primaryPhoneNumber, secondarySecondaryNumber);
        }
}
