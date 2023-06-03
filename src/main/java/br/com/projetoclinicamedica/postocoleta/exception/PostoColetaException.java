package br.com.projetoclinicamedica.postocoleta.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostoColetaException extends RuntimeException{

    public PostoColetaException(Long codigo) {

        log.error(" O Posto Coletá já está cadastrado, por favor inserir outro para continuar " + codigo);

    }
}
