package com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.agenda.entities.agenda;

public interface agendaRepository extends JpaRepository<agenda, Long>{
    
}
