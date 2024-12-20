package com.agenda.agenda.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.agenda.agenda.dtos.agendaRequest;
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

public agendaResponse save(agendaRequest agenda){
    agenda newaAgenda = repository.save(agendaMapper.toEntity(agenda));
    return agendaMapper.toDTO(newaAgenda);
}

public void update(agendaRequest agenda, long id){

    agenda aux = repository.getReferenceById(id);

    aux.setTitulo(agenda.titulo());
    aux.setDescricao(agenda.descricao());
    aux.setData(agenda.data());
    aux.setHora(agenda.hora());

    repository.save(aux);
}

public void delete(long id){
    if(repository.existsById(id)){
        repository.deleteById(id);
    }
    else{
        throw new EntityNotFoundException("Compromisso não agendado");
    }
}
}
