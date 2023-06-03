package br.com.projetoclinicamedica.postocoleta.service;

import br.com.projetoclinicamedica.postocoleta.dto.PostoColetaDTO;
import br.com.projetoclinicamedica.postocoleta.exception.PostoColetaException;
import br.com.projetoclinicamedica.postocoleta.factory.PostoColetaFactory;
import br.com.projetoclinicamedica.postocoleta.model.PostoColeta;
import br.com.projetoclinicamedica.postocoleta.repository.PostoColetaRepository;
import br.com.projetoclinicamedica.postocoleta.vo.PostoColetaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostoColetaService {

    private final PostoColetaRepository postoColetaRepository;

    private final PostoColetaFactory postoColetaFactory;

    public List<PostoColetaVO> getAll() {
        return this.postoColetaRepository.listAll();
    }

    public Optional<PostoColetaVO> detalhar(Long codigoColeta) {
        return this.postoColetaRepository.findByOne(codigoColeta);
    }

    public Long salvar(PostoColetaDTO postoColetaDTO) {

        this.postoColetaRepository.findById(
             postoColetaDTO.getCodigoColeta()
        ).ifPresent(idPaciente -> {
                    throw new PostoColetaException(postoColetaDTO.getCodigoColeta());
                }
        );

        return this.postoColetaRepository.save(
                this.postoColetaFactory.createFactoryPostoColeta(postoColetaDTO)
        ).getCodigoColeta();
    }

    public Optional<Long> alterar(Long id, PostoColetaDTO postoColetaDTO)
    {
        return this.postoColetaRepository.findById(id)
                .map(postoColeta ->
                        postoColeta.toBuilder()
                                .descricao(postoColetaDTO.getDescricao())
                                .endereco(postoColetaDTO.getEndereco())
                                .build()

                ).map(this.postoColetaRepository::save)
                .map(PostoColeta::getCodigoColeta);


    }

}
