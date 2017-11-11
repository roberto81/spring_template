package com.example.demo.dto;
import java.util.List;

/**
 * Created by ropal on 17/10/2017.
 */
public class PersonDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private ContactDTO contactDTO;
    private List<NotaDTO> note;

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

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    public List<NotaDTO> getNote() {
        return note;
    }

    public void setNote(List<NotaDTO> note) {
        this.note = note;
    }
}
