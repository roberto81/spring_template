package com.example.demo.service;

import com.example.demo.dto.NotaDTO;
import com.example.demo.entity.Nota;
import com.example.demo.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;
    private List<NotaDTO> notaListDTO = new ArrayList<>();
    private List<Nota> notaListEntity = new ArrayList<>();

    public  List<NotaDTO> findAlNote(){
        this.notaListEntity = notaRepository.findAll();

        for (Nota nota : notaListEntity) {

            NotaDTO notaDTO = new NotaDTO();
            notaDTO.setId(nota.getId());
            notaDTO.setTitle(nota.getDescription());
            notaDTO.setDescription(nota.getDescription());
            this.notaListDTO.add(notaDTO);
        }
        return this.notaListDTO;
    }

    public NotaDTO addNota( NotaDTO dto){

        Nota entity = new Nota();
        entity.setTitle( dto.getTitle() );
        entity.setDescription( dto.getDescription() );

        entity = notaRepository.save(entity);
        NotaDTO dtoresult = new NotaDTO();
        dtoresult.setId( entity.getId() );
        dtoresult.setTitle( entity.getTitle() );
        dtoresult.setDescription( entity.getDescription() );

        return dtoresult;
    }

    public NotaDTO findOneNota( Integer id ){
        Nota entity = notaRepository.findOne(id);

        NotaDTO dtoresult = new NotaDTO();
        dtoresult.setId( entity.getId() );
        dtoresult.setTitle( entity.getTitle() );
        dtoresult.setDescription( entity.getDescription() );

        return dtoresult;
    }

    public NotaDTO updateNota( NotaDTO dto){
        Nota entity = new Nota();
        entity.setId( dto.getId() );
        entity.setTitle( dto.getTitle() );
        entity.setDescription( dto.getDescription() );

        try {
            notaRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        entity = notaRepository.findOne( entity.getId() );

        NotaDTO dtoresult = new NotaDTO();
        dtoresult.setId( entity.getId() );
        dtoresult.setTitle( entity.getTitle() );
        dtoresult.setDescription( entity.getDescription() );

        return dtoresult;

    }

    public void deleteNota(NotaDTO dto){

        Nota entity = new Nota();
        entity.setId( dto.getId() );
        entity.setTitle( dto.getTitle() );
        entity.setDescription( dto.getDescription() );

        try {
            notaRepository.delete(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteNota(Integer id){
        notaRepository.delete(id);
    }

}
