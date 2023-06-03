package br.com.projetoclinicamedica.agenda.vo;

import java.time.LocalDateTime;

public record AgendaVO(Long codigo,  String nome, String nomeMedico, LocalDateTime horarioAgendamento) {
// paciente -> nome
}
