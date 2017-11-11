package com.example.demo.rest;

import com.example.demo.dto.PersonDTO;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonRestController {

    private ResourceLoader resourceLoader;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "rest/allperson", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<PersonDTO>> findAll() {

        ResponseEntity< List<PersonDTO> > responseEntity = null;

        try {
            responseEntity = new ResponseEntity<List<PersonDTO>>(personService.findAllPerson(), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

    }


    @RequestMapping(value = "rest/findPersonById", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<PersonDTO> findOnePerson(@RequestParam("id") Integer id) {

        ResponseEntity<PersonDTO> responseEntity = null;

        try {
            responseEntity = new ResponseEntity<PersonDTO>(personService.findOnePerson(id), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;

    }

    @RequestMapping(value = "rest/addperson", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PersonDTO> addPerson(@RequestBody PersonDTO dto) {

        ResponseEntity<PersonDTO> responseEntity = null;

        try {
           responseEntity = new ResponseEntity<PersonDTO>( personService.addPerson(dto), HttpStatus.CREATED );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/updatePerson", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO dto){

        ResponseEntity<PersonDTO> responseEntity = null;
        try {

            PersonDTO result = personService.updatePerson(dto);
            responseEntity = new ResponseEntity<PersonDTO>( result, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/deletePersonById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deletePersonById(@RequestParam("id") Integer id){

        ResponseEntity responseEntity = null;

        try {

            personService.deletePerson( id );
            responseEntity = new ResponseEntity(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/deletePerson", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deletePerson(@RequestBody PersonDTO dto){

        ResponseEntity responseEntity = null;

        try {

            personService.deletePerson( dto );
            responseEntity = new ResponseEntity(HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }


}
