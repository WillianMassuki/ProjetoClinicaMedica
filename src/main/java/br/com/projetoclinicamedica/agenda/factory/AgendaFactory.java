package br.com.projetoclinicamedica.agenda.factory;

import br.com.projetoclinicamedica.agenda.dto.AgendaDTO;
import br.com.projetoclinicamedica.agenda.model.Agenda;
import org.springframework.stereotype.Component;

@Component
public class AgendaFactory {

    public Agenda createFrom(AgendaDTO agendaDTO)
    {
        return   Agenda.builder()
                .medico(agendaDTO.getMedico())
                .paciente(agendaDTO.getPaciente())
                .horarioAgendamento(agendaDTO.getHorarioAgendamento())
                .build();

    }
}
