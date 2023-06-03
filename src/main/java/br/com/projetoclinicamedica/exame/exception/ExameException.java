package br.com.projetoclinicamedica.exame.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExameException extends RuntimeException{

    public ExameException(Long codigo) {
        log.error(" O exame já foi cadastrado, por favor inserir outro para prosseguir" + codigo);

    }
}
