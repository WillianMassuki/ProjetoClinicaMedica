package br.com.projetoclinicamedica.paciente.service;

import br.com.projetoclinicamedica.paciente.dto.PacienteDTO;
import br.com.projetoclinicamedica.paciente.exception.PacienteJaAgendadoException;
import br.com.projetoclinicamedica.paciente.factory.PacienteFactory;
import br.com.projetoclinicamedica.paciente.repository.PacienteRepository;
import br.com.projetoclinicamedica.paciente.vo.PacienteVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    private final PacienteFactory pacienteFactory;

    public List<PacienteVO> listAll()
    {
        return this.pacienteRepository.listAll();

    }

    public Optional<PacienteVO> detalhar(Long idPaciente)
    {

        return this.pacienteRepository.findByOne(idPaciente);
    }

    public Long salvar(PacienteDTO pacienteDTO) {

        this.pacienteRepository.findByOne(
                pacienteDTO.getCodigo()
        ).ifPresent(idPaciente -> {
                    throw new PacienteJaAgendadoException(pacienteDTO.getCodigo());
                }
        );

        return this.pacienteRepository.save(
                this.pacienteFactory.createFrom(pacienteDTO)
        ).getCodigo();
    }

}
