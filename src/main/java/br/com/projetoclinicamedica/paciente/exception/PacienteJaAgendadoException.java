package br.com.projetoclinicamedica.paciente.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Slf4j
public class PacienteJaAgendadoException extends RuntimeException{

    public PacienteJaAgendadoException(Long codigo) {

        log.error(" O horario já está agendadp, por favor faça alteração. " + codigo);

    }
}
