package com.agenda.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.agenda.dtos.agendaResponse;
import com.agenda.agenda.services.agendaService;

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
}
