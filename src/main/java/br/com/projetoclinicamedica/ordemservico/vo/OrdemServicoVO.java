package br.com.projetoclinicamedica.ordemservico.vo;

import java.time.LocalDateTime;

/**
 * @param nome       paciente
 * @param descricao  Posto coleta
 * @param nomeMedico Medico
 */

public record OrdemServicoVO(Long codigoServico, LocalDateTime data, String nome, String convenio, String descricao,
                             String nomeMedico) {

}
