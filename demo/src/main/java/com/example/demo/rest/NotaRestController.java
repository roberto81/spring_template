package com.example.demo.rest;

import com.example.demo.dto.NotaDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotaRestController {

    @Autowired
    NotaService notaService;

    @RequestMapping(value = "rest/allNote", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity< List<NotaDTO> > findAll(){

        ResponseEntity< List<NotaDTO> > responseEntity = null;
        try {
            responseEntity = new ResponseEntity<List<NotaDTO>>( notaService.findAlNote(), HttpStatus.CREATED );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/findNotaById", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<NotaDTO> findOneNota(@RequestParam("id") Integer id){
        ResponseEntity<NotaDTO> responseEntity = null;

        try {
            NotaDTO result = notaService.findOneNota(id);
            responseEntity = new ResponseEntity<NotaDTO>(result ,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }


    @RequestMapping(value = "rest/addNota", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<NotaDTO> addNota(@RequestBody NotaDTO dto){

        ResponseEntity< NotaDTO > responseEntity = null;
        try {
            responseEntity = new ResponseEntity<NotaDTO>(notaService.addNota(dto),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/updateNota", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<NotaDTO> updateNota(@RequestBody NotaDTO dto){

        ResponseEntity<NotaDTO> responseEntity = null;
        try {
            NotaDTO result = notaService.updateNota(dto);
            responseEntity = new ResponseEntity<NotaDTO>(result,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "rest/deleteNotaById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteNotaById(@RequestParam("id") Integer id){
        ResponseEntity responseEntity = null;
        try {
            notaService.deleteNota(id);
            responseEntity = new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }

    @RequestMapping(value = "rest/deleteNota", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteNotaById(@RequestBody NotaDTO dto){
        ResponseEntity responseEntity = null;
        try {
            notaService.deleteNota(dto);
            responseEntity = new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }
}
