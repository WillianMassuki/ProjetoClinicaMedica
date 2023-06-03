package br.com.projetoclinicamedica.medico.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MedicoJaCadastradoException extends RuntimeException {
    public MedicoJaCadastradoException(Long codigo) {

        log.error("O Profissional ja foi cadastrado em nosso sistema" + codigo);

    }
}
