package com.agenda.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.agenda.dtos.agendaResponse;
import com.agenda.agenda.entities.agenda;
import com.agenda.agenda.mappers.agendaMapper;
import com.agenda.agenda.repositories.agendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class agendaService {
    
    @Autowired
    private agendaRepository repository;

    public List<agendaResponse> getAllagenda() {
return repository.findAll().stream().map(p -> agendaMapper.toDTO(p)).collect(Collectors.toList());
    }
public agendaResponse getagendaById(long id){
    agenda agenda = repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException ("Compromisso não agendado")
    );

    return agendaMapper.toDTO(agenda);

    }
}
