package com.example.demo.rest;

import com.example.demo.dto.ContactDTO;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "rest/allcontact", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<ContactDTO>> findAll(){
        ResponseEntity< List<ContactDTO> > responseEntity = null;
        try {
            responseEntity = new ResponseEntity<List<ContactDTO>>(contactService.findAlContact(), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @RequestMapping(value = "rest/addcontact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactDTO dto){
        ResponseEntity<ContactDTO> responseEntity = null;

        try {
            responseEntity = new ResponseEntity<ContactDTO>(contactService.addContact(dto),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/findContactById", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ContactDTO> findOneNota(@RequestParam("id") Integer id){
        ResponseEntity<ContactDTO> responseEntity = null;

        try {
            ContactDTO result = contactService.findOneContact(id);
            responseEntity = new ResponseEntity<ContactDTO>(result ,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/updateContact", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ContactDTO> updateNota(@RequestBody ContactDTO dto){
        ResponseEntity<ContactDTO> responseEntity = null;

        try {
            ContactDTO result = contactService.updateContact(dto);
            responseEntity = new ResponseEntity<ContactDTO>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  responseEntity;
    }

    @RequestMapping(value = "rest/deleteContactById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteContactById(@RequestParam("id") Integer id){

        ResponseEntity responseEntity = null;

        try {
            contactService.deleteContact(id);
            responseEntity = new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/deleteContact", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteContact(@RequestBody ContactDTO dto){
        ResponseEntity responseEntity = null;

        try {
            contactService.deleteContact(dto);
            responseEntity = new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
}
