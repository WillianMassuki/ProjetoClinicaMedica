package br.com.projetoclinicamedica.agenda.dto;

import br.com.projetoclinicamedica.medico.model.Medico;
import br.com.projetoclinicamedica.paciente.model.Paciente;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class AgendaDTO {

    private Long codigo;

    private Paciente paciente;

    private Medico medico;

    private LocalDateTime horarioAgendamento;
}
