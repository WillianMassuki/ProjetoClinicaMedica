package br.com.projetoclinicamedica.ordemservico.service;

import br.com.projetoclinicamedica.ordemservico.dto.OrdemServicoDTO;
import br.com.projetoclinicamedica.ordemservico.exception.OrdemServicoException;
import br.com.projetoclinicamedica.ordemservico.factory.OrdemServicoFactory;
import br.com.projetoclinicamedica.ordemservico.repository.OrdemServicoRepository;
import br.com.projetoclinicamedica.ordemservico.vo.OrdemServicoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;

    private final OrdemServicoFactory ordemServicoFactory;

    public List<OrdemServicoVO> getAll() {
        return this.ordemServicoRepository.listAll();
    }

    public Optional<OrdemServicoVO> detalhar(Long codigoServico) {
        return this.ordemServicoRepository.findByOne(codigoServico);
    }

    public Long salvar(OrdemServicoDTO ordemServicoDTO) {

        this.ordemServicoRepository.findById(
                ordemServicoDTO.getCodigoServico()
        ).ifPresent(codigo -> {
                    throw new OrdemServicoException(ordemServicoDTO.getCodigoServico());
                }
        );

        return this.ordemServicoRepository.save(
                this.ordemServicoFactory.createFactoryOrdemServico(ordemServicoDTO)
        ).getCodigoServico();
    }

}
