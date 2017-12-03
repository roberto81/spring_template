package com.example.demo.service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<ContactDTO> findAlContact() {

        List<ContactDTO> responseList = new ArrayList<ContactDTO>();
        List<Contact> findAllList = contactRepository.findAll();

        for (Contact c : findAllList )
        {
            ContactDTO contact = new ContactDTO();
            contact.setId( c.getId() );
            contact.setEmail( c.getEmail() );
            contact.setPrimaryPhoneNumber( c.getPrimaryPhoneNumber() );
            contact.setSecondarySecondaryNumber( c.getSecondarySecondaryNumber() );
            responseList.add( contact );
        }
        return responseList;
    }

    public ContactDTO addContact( ContactDTO dto){
        Contact entity = new Contact();
        entity.setEmail(dto.getEmail());
        entity.setPrimaryPhoneNumber( dto.getPrimaryPhoneNumber() );
        entity.setSecondarySecondaryNumber( dto.getSecondarySecondaryNumber() );
        entity =contactRepository.save(entity);

        ContactDTO dtoresult = new ContactDTO();
        dtoresult.setId( entity.getId() );
        dtoresult.setEmail( entity.getEmail() );
        dtoresult.setPrimaryPhoneNumber( entity.getPrimaryPhoneNumber() );
        dtoresult.setSecondarySecondaryNumber( entity.getSecondarySecondaryNumber() );

        return dtoresult;
    }

    public ContactDTO findOneContact( Integer id ) throws EntityNotFoundException{
        Contact entity = contactRepository.findOne(id);

        if(null == entity){
            throw new EntityNotFoundException("Il contatto con id: " + id +" non è presente");
        }

        ContactDTO dtoresult = new ContactDTO();
        dtoresult.setId( entity.getId() );
        dtoresult.setEmail( entity.getEmail() );
        dtoresult.setPrimaryPhoneNumber( entity.getPrimaryPhoneNumber() );
        dtoresult.setSecondarySecondaryNumber( entity.getSecondarySecondaryNumber() );

        return dtoresult;
    }

    public ContactDTO updateContact( ContactDTO dto){

        Contact entity = contactRepository.findOne(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPrimaryPhoneNumber( dto.getPrimaryPhoneNumber() );
        entity.setSecondarySecondaryNumber( dto.getSecondarySecondaryNumber() );

        try {
            contactRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        entity = contactRepository.findOne( entity.getId() );

        ContactDTO dtoresult = new ContactDTO();
        dtoresult.setId( entity.getId() );
        dtoresult.setEmail( entity.getEmail() );
        dtoresult.setPrimaryPhoneNumber( entity.getPrimaryPhoneNumber() );
        dtoresult.setSecondarySecondaryNumber( entity.getSecondarySecondaryNumber() );

        return dtoresult;
    }

    public void deleteContact(ContactDTO dto){
        Contact entity = contactRepository.findOne(dto.getId());

        try {
            contactRepository.delete(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(Integer id){
        contactRepository.delete(id);
    }

}
