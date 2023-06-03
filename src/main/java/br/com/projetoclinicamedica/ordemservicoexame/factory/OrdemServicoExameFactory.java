package br.com.projetoclinicamedica.ordemservicoexame.factory;

import br.com.projetoclinicamedica.ordemservicoexame.dto.OrdemServicoExameDTO;
import br.com.projetoclinicamedica.ordemservicoexame.model.OrdemServicoExame;
import org.springframework.stereotype.Component;

@Component
public class OrdemServicoExameFactory {

    public OrdemServicoExame createFactoryOrdemServicoExame(OrdemServicoExameDTO ordemServicoExameDTO)
    {
        return OrdemServicoExame.builder()
                .ordemServico(ordemServicoExameDTO.getOrdemServico())
                .exame(ordemServicoExameDTO.getExame())
                .preco(ordemServicoExameDTO.getPreco())
                .build();
    }
}
