package br.com.projetoclinicamedica.exame.factory;

import br.com.projetoclinicamedica.exame.dto.ExameDTO;
import br.com.projetoclinicamedica.exame.model.Exame;
import org.springframework.stereotype.Component;

@Component
public class ExameFactory {

    public Exame createFactoryExame(ExameDTO exameDTO)
    {
        return Exame.builder()
                .preco(exameDTO.getPreco())
                .descricao(exameDTO.getDescricao())
                .build();
    }
}
