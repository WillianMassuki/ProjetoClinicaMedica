package br.com.projetoclinicamedica.ordemservicoexame.dto;

import br.com.projetoclinicamedica.exame.model.Exame;
import br.com.projetoclinicamedica.ordemservico.model.OrdemServico;
import lombok.Data;

@Data
public class OrdemServicoExameDTO {

    private Long codigo;

    private OrdemServico ordemServico;

    private Exame exame;

    private Double preco;

}
