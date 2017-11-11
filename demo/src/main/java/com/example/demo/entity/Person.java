package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.util.List;


/**
 * Created by ropal on 18/10/2017.
 */

@Entity
@Table(name = "PERSON")
//@SequenceGenerator(name = "PERSON_SEQ", sequenceName = "PERSON_SEQ", initialValue = 1 )
@GenericGenerator(
        name = "personSequenceGenerator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "PERSON_SEQUENCE"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class Person {

    @Id
    //@GeneratedValue(generator = "PERSON_SEQ")
    @GeneratedValue(generator = "personSequenceGenerator")
    private Integer id;

    /*
    l   la sintesi camel case fa si che il nome della colonna generata nel database
        sia es: firstName = first_name
     */

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    /*
        name si riferisce alla colonna utilizzata per effettuare il join, non deve essere creata
        come campo field della classe entity dato che si sta dichiarando questa colonna su una proprietà che di fatto è
        già un'istanza della Classe Contact.

        referencedColumnName si riferisce alla colonna id della taella che rappresenta la Classe Contact.

        foreignKey = @ForeignKey(name = "fk_person_contact") si utilizza per definire la foreignKey per la quale
        si possono specificare diversi parametri.

     */
    @JoinColumn(name = "contact_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_person_contact"))
    private Contact contact;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_note_person"))
    private List<Nota> nota;

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Nota> getNota() {
        return nota;
    }

    public void setNota(List<Nota> nota) {
        this.nota = nota;
    }
}
