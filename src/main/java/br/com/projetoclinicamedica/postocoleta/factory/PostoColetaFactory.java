package br.com.projetoclinicamedica.postocoleta.factory;

import br.com.projetoclinicamedica.postocoleta.dto.PostoColetaDTO;
import br.com.projetoclinicamedica.postocoleta.model.PostoColeta;
import org.springframework.stereotype.Component;

@Component
public class PostoColetaFactory {

    public PostoColeta createFactoryPostoColeta(PostoColetaDTO postoColetaDTO )
    {
        return PostoColeta.builder()
                .descricao(postoColetaDTO.getDescricao())
                .endereco(postoColetaDTO.getEndereco())
                .build();

    }
}
