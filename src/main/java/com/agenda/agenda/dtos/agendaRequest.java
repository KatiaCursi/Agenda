package com.agenda.agenda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;

public record agendaRequest(
    
@NotBlank(message = "Não pode ser em branco")
     String titulo,
     
     String descricao,
     
     LocalDate data,
     
     LocalTime hora
) {
    
}
