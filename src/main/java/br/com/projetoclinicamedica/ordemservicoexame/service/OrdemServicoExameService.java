package br.com.projetoclinicamedica.ordemservicoexame.service;

import br.com.projetoclinicamedica.ordemservicoexame.dto.OrdemServicoExameDTO;
import br.com.projetoclinicamedica.ordemservicoexame.exception.OrdemServicoExameException;
import br.com.projetoclinicamedica.ordemservicoexame.factory.OrdemServicoExameFactory;
import br.com.projetoclinicamedica.ordemservicoexame.repository.OrdemServicoExameRepository;
import br.com.projetoclinicamedica.ordemservicoexame.vo.OrdemServicoExameVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemServicoExameService {

    private final OrdemServicoExameRepository ordemServicoExameRepository;

    private final OrdemServicoExameFactory ordemServicoExameFactory;

    public List<OrdemServicoExameVO> findByAll()
    {
        return this.ordemServicoExameRepository.listAll();

    }

    public Optional<OrdemServicoExameVO> detalhar(Long codigoOrdemServicoExame)
    {

        return this.ordemServicoExameRepository.findByOne(codigoOrdemServicoExame);
    }

    public Long salvar(OrdemServicoExameDTO ordemServicoExameDTO) {

        this.ordemServicoExameRepository.findByOne(
               ordemServicoExameDTO.getCodigo()
        ).ifPresent(codigo -> {
                    throw new OrdemServicoExameException(ordemServicoExameDTO.getCodigo());
                }
        );

        return this.ordemServicoExameRepository.save(
                this.ordemServicoExameFactory.createFactoryOrdemServicoExame(ordemServicoExameDTO)
        ).getCodigo();
    }
}
