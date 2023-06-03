package br.com.projetoclinicamedica.medico.service;

import br.com.projetoclinicamedica.medico.dto.MedicoDTO;
import br.com.projetoclinicamedica.medico.factory.MedicoFactory;
import br.com.projetoclinicamedica.medico.repository.MedicoRepository;
import br.com.projetoclinicamedica.medico.vo.MedicoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    private final MedicoFactory medicoFactory;

    public List<MedicoVO> listAll()
    {
        return this.medicoRepository.findByAll();

    }

    public Optional<MedicoVO> detalhar(Long codigoMedico)
    {
        return this.medicoRepository.findByOne(codigoMedico);
    }

    public Long salvar(MedicoDTO medicoDTO) {

        this.medicoRepository.findById(
                medicoDTO.getCodigo()
        ).ifPresent(idPrograma -> {
                    throw new MedicoJaCadastradoException(medicoDTO.getCodigo());
                }
        );

        return this.medicoRepository.save(
                this.medicoFactory.createFrom(medicoDTO)
        ).getCodigoMedico();
    }

}
