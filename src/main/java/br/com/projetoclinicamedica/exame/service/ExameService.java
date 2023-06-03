package br.com.projetoclinicamedica.exame.service;

import br.com.projetoclinicamedica.exame.dto.ExameDTO;
import br.com.projetoclinicamedica.exame.exception.ExameException;
import br.com.projetoclinicamedica.exame.factory.ExameFactory;
import br.com.projetoclinicamedica.exame.model.Exame;
import br.com.projetoclinicamedica.exame.repository.ExameRepository;
import br.com.projetoclinicamedica.exame.vo.ExameVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExameService {

    private final ExameRepository exameRepository;

    private final ExameFactory exameFactory;

    public List<ExameVO> getAll() {
        return this.exameRepository.findByAll();
    }

    public Optional<ExameVO> detalhar(Long codigoExame) {
        return this.exameRepository.findByOne(codigoExame);
    }

    public Optional<Long> alterar(Long id, ExameDTO exameDTO)
    {
        return this.exameRepository.findById(id)
                .map(exame ->
                        exame.toBuilder()
                                .preco(exameDTO.getPreco())
                                .descricao(exameDTO.getDescricao())
                                .build()

                ).map(this.exameRepository::save)
                .map(Exame::getCodigoExame);
    }

    public Long salvar(ExameDTO exameDTO)
    {
        this.exameRepository.findByOne(
                exameDTO.getCodigoExame()
        ).ifPresent(codigoExame -> {
            throw new ExameException(exameDTO.getCodigoExame());

        }
        );

        return this.exameRepository.save(
                this.exameFactory.createFactoryExame(exameDTO)
        ).getCodigoExame();

    }


}
