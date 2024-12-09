package com.agenda.agenda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record agendaResponse(


    
     Long id,
     String titulo,
     String descricao,
     LocalDate data,
     LocalTime hora
   
){
    
}
