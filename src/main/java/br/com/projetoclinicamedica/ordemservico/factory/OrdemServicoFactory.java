package br.com.projetoclinicamedica.ordemservico.factory;

import br.com.projetoclinicamedica.ordemservico.dto.OrdemServicoDTO;
import br.com.projetoclinicamedica.ordemservico.model.OrdemServico;
import org.springframework.stereotype.Component;

@Component
public class OrdemServicoFactory {

    public OrdemServico createFactoryOrdemServico(OrdemServicoDTO ordemServicoDTO)
    {
        return OrdemServico.builder()
                .postoColeta(ordemServicoDTO.getPostoColeta())
                .data(ordemServicoDTO.getData())
                .convenio(ordemServicoDTO.getConvenio())
                .paciente(ordemServicoDTO.getPaciente())
                .medico(ordemServicoDTO.getMedico())
                .build();
    }
}
