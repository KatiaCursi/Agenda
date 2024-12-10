package com.agenda.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.agenda.dtos.agendaRequest;
import com.agenda.agenda.dtos.agendaResponse;
import com.agenda.agenda.services.agendaService;

@CrossOrigin
@RestController
@RequestMapping("agenda")
public class agendaController {

    @Autowired
    private agendaService service;
    
    @GetMapping
    public ResponseEntity<List<agendaResponse>> getagenda(){
        return ResponseEntity.ok(service.getAllagenda());  
    }
        @GetMapping("{id}")
        public ResponseEntity<agendaResponse> getgenda(@PathVariable long id){
            return ResponseEntity.ok(service.getagendaById(id));
        }

        @PostMapping()
        public ResponseEntity<agendaResponse>saveagenda(@Validated @RequestBody agendaRequest agenda){
            agendaResponse newagenda = service.save(agenda);
            return ResponseEntity.created(null).body(newagenda);
        }

        @PutMapping("{id}")
        public ResponseEntity<Void> updateagenda(@PathVariable long id, @Validated @RequestBody agendaRequest agenda){
            service.update(agenda, id);
            return ResponseEntity.ok().build();
        }

        @DeleteMapping("{id}")
        public ResponseEntity<Void>deleteagenda(@PathVariable long id){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

}
