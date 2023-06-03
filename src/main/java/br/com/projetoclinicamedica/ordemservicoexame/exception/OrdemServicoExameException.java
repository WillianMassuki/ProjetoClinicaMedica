package br.com.projetoclinicamedica.ordemservicoexame.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrdemServicoExameException extends RuntimeException{

    public OrdemServicoExameException(Long codigo) {

        log.error(" Ordem Servico do Exame já está cadastrado, por favor inserir outro... " + codigo);
    }
}
