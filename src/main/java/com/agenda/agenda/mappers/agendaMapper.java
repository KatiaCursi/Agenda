package com.agenda.agenda.mappers;
import com.agenda.agenda.dtos.agendaRequest;
import com.agenda.agenda.dtos.agendaResponse;
import com.agenda.agenda.entities.agenda;

public class agendaMapper {

    

public static agendaResponse toDTO (com.agenda.agenda.entities.agenda agenda) {
    return new agendaResponse(agenda.getId(),
                              agenda.getTitulo(),
                              agenda.getDescricao(),
                              agenda.getData(),
                              agenda.getHora());
}

public static agenda toEntity(agendaRequest agendaRequest){
    agenda agenda = new agenda();

    agenda.setTitulo(agendaRequest.titulo());
    agenda.setDescricao(agendaRequest.descricao());
    agenda.setData(agendaRequest.data());
    agenda.setHora(agendaRequest.hora());

    return agenda;
}
}