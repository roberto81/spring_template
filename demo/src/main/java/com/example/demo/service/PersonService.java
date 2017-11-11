package com.example.demo.service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.NotaDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Nota;
import com.example.demo.entity.Person;
import com.example.demo.repository.Personrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ropal on 18/10/2017.
 */

@Service
public class PersonService {

    @Autowired
    Personrepository personRepository;

    private List<Nota> notaListEntity = new ArrayList<>();
    private List<NotaDTO> noteListDTO = new ArrayList<>();

    public List<PersonDTO> findAllPerson(){

        List<PersonDTO> responseList = new ArrayList<PersonDTO>();
        List<Person> findAllList = personRepository.findAll();

        for (Person p:findAllList)
        {
            PersonDTO person = new PersonDTO();
            person.setId(p.getId());
            person.setFirstName(p.getFirstName());
            person.setLastName(p.getLastName());

            ContactDTO contactDTO = new ContactDTO();
            contactDTO.setId(p.getContact().getId());
            contactDTO.setEmail(p.getContact().getEmail());
            contactDTO.setPrimaryPhoneNumber(p.getContact().getPrimaryPhoneNumber());
            contactDTO.setSecondarySecondaryNumber(p.getContact().getSecondarySecondaryNumber());

            person.setContactDTO( contactDTO );

            this.noteListDTO = new ArrayList<>();
            this.notaListEntity = p.getNota();

            for (Nota notaEntity : notaListEntity) {

                NotaDTO notaDTO = new NotaDTO();
                notaDTO.setId(notaEntity.getId());
                notaDTO.setTitle(notaEntity.getTitle());
                notaDTO.setDescription(notaEntity.getDescription());
                noteListDTO.add(notaDTO);

            }

            person.setNote(noteListDTO);
            responseList.add(person);
        }

        return responseList;

    }
    public PersonDTO findOnePerson( Integer id ){
        Person entity = new Person();
        entity = personRepository.findOne( id );

        PersonDTO dtoresult = new PersonDTO();
        dtoresult.setFirstName(entity.getFirstName());
        dtoresult.setLastName(entity.getLastName());
        dtoresult.setId(entity.getId());

        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(entity.getContact().getId());
        contactDTO.setEmail(entity.getContact().getEmail());
        contactDTO.setPrimaryPhoneNumber(entity.getContact().getPrimaryPhoneNumber());
        contactDTO.setSecondarySecondaryNumber(entity.getContact().getSecondarySecondaryNumber());
        dtoresult.setContactDTO(contactDTO);

        this.notaListEntity = entity.getNota();
        this.noteListDTO = new ArrayList<>();
        for (Nota notaEntity : notaListEntity) {
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setId( notaEntity.getId() );
            notaDTO.setTitle( notaEntity.getTitle() );
            notaDTO.setDescription( notaEntity.getDescription() );
            noteListDTO.add(notaDTO);
        }
        dtoresult.setNote(noteListDTO);

        return dtoresult;
    }

    public PersonDTO addPerson(PersonDTO dto ){

        Person entity = new Person();
        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );

        Contact contact = new Contact();
        contact.setEmail( dto.getContactDTO().getEmail() );
        contact.setPrimaryPhoneNumber( dto.getContactDTO().getPrimaryPhoneNumber() );
        contact.setSecondarySecondaryNumber( dto.getContactDTO().getSecondarySecondaryNumber() );

        entity.setContact(contact);

        this.notaListEntity = new ArrayList<>();
        this.noteListDTO = dto.getNote();
        for (NotaDTO notaDTO : noteListDTO) {
            Nota nota = new Nota();
            nota.setId( notaDTO.getId() );
            nota.setTitle( notaDTO.getTitle() );
            nota.setDescription( notaDTO.getDescription() );
            notaListEntity.add( nota );
        }

        entity.setNota(notaListEntity);

        entity = personRepository.save(entity);

        ContactDTO contactResult = new ContactDTO();
        contactResult.setId(entity.getContact().getId());
        contactResult.setEmail(entity.getContact().getEmail());
        contactResult.setPrimaryPhoneNumber(entity.getContact().getPrimaryPhoneNumber());
        contactResult.setSecondarySecondaryNumber(entity.getContact().getSecondarySecondaryNumber());

        PersonDTO dtoresult = new PersonDTO();
        dtoresult.setFirstName(entity.getFirstName());
        dtoresult.setLastName(entity.getLastName());
        dtoresult.setId(entity.getId());
        dtoresult.setContactDTO(contactResult);

        this.notaListEntity = entity.getNota();
        this.noteListDTO = new ArrayList<>();
        for (Nota notaEntity : notaListEntity) {
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setId( notaEntity.getId() );
            notaDTO.setTitle( notaEntity.getTitle() );
            notaDTO.setDescription( notaEntity.getDescription() );
            noteListDTO.add(notaDTO);
        }

        dtoresult.setNote(noteListDTO);

        return dtoresult;
    }

    public void deletePerson( Integer id){
        personRepository.delete( id );
    }

    public void deletePerson(PersonDTO dto){
        Person entity = new Person();

        entity.setId( dto.getId() );
        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );

        Contact contact = new Contact();
        contact.setId( dto.getContactDTO().getId() );
        contact.setEmail( dto.getContactDTO().getEmail() );
        contact.setPrimaryPhoneNumber( dto.getContactDTO().getPrimaryPhoneNumber() );
        contact.setSecondarySecondaryNumber( dto.getContactDTO().getSecondarySecondaryNumber() );

        entity.setContact( contact );
        this.noteListDTO = dto.getNote();
        this.notaListEntity = new ArrayList<>();
        for (NotaDTO notaDTO : noteListDTO) {
            Nota nota = new Nota();
            nota.setId( notaDTO.getId() );
            nota.setTitle( notaDTO.getTitle() );
            nota.setDescription( notaDTO.getDescription() );
            notaListEntity.add( nota );
        }
        entity.setNota(notaListEntity);

        try {
            personRepository.delete( entity );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PersonDTO updatePerson( PersonDTO dto){
        Person entity = new Person();

        entity.setId( dto.getId() );

        entity = personRepository.findOne( entity.getId() );
        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );

        Contact contact = entity.getContact();
        contact.setId(dto.getContactDTO().getId());
        contact.setEmail(dto.getContactDTO().getEmail());
        contact.setPrimaryPhoneNumber(dto.getContactDTO().getPrimaryPhoneNumber());
        contact.setSecondarySecondaryNumber(dto.getContactDTO().getSecondarySecondaryNumber());

        this.noteListDTO = dto.getNote();
        this.notaListEntity = new ArrayList<>();
        for (NotaDTO notaDTO : noteListDTO) {
            Nota nota = new Nota();
            nota.setId( notaDTO.getId() );
            nota.setTitle( notaDTO.getTitle() );
            nota.setDescription( notaDTO.getDescription() );
            notaListEntity.add( nota );
        }
        entity.setNota(notaListEntity);

        /*
         dato che l'entity è gestita dall'entitymanager di hibernate
         è sufficente aggiornare le proprietà ed effettuare un flush del
         repository.
         */
        try {
            personRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        entity = personRepository.findOne(entity.getId());

        PersonDTO dtoresult = new PersonDTO();
        dtoresult.setFirstName(entity.getFirstName());
        dtoresult.setLastName(entity.getLastName());
        dtoresult.setId(entity.getId());

        ContactDTO contactResult = new ContactDTO();
        contactResult.setId(entity.getContact().getId());
        contactResult.setEmail(entity.getContact().getEmail());
        contactResult.setPrimaryPhoneNumber(entity.getContact().getPrimaryPhoneNumber());
        contactResult.setSecondarySecondaryNumber(entity.getContact().getSecondarySecondaryNumber());
        dtoresult.setContactDTO(contactResult);

        this.notaListEntity = entity.getNota();
        this.noteListDTO = new ArrayList<>();
        for (Nota notaEntity : notaListEntity) {
            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setId( notaEntity.getId() );
            notaDTO.setTitle( notaEntity.getTitle() );
            notaDTO.setDescription( notaEntity.getDescription() );
            noteListDTO.add(notaDTO);
        }

        dtoresult.setNote(noteListDTO);
        return dtoresult;
    }
}
