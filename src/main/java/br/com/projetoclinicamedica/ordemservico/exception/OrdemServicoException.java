package br.com.projetoclinicamedica.ordemservico.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrdemServicoException extends RuntimeException {
    public OrdemServicoException(Long codigo) {

        log.error(" A Ordem serviço já foi adicionada, por favor adiocinar outra, " + codigo);
    }
}
