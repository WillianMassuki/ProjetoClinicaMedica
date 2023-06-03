package br.com.projetoclinicamedica.agenda.service;

import br.com.projetoclinicamedica.agenda.dto.AgendaDTO;
import br.com.projetoclinicamedica.agenda.factory.AgendaFactory;
import br.com.projetoclinicamedica.agenda.model.Agenda;
import br.com.projetoclinicamedica.agenda.repository.AgendaRepository;
import br.com.projetoclinicamedica.agenda.vo.AgendaVO;
import br.com.projetoclinicamedica.paciente.exception.PacienteJaAgendadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    private final AgendaFactory agendaFactory;

    public List<AgendaVO> listAll()
    {
        return this.agendaRepository.listAll();

    }

    public Optional<Agenda> detalhar(Long idAgenda)
    {
        return this.agendaRepository.findById(idAgenda);
    }

    public Long salvar(AgendaDTO agendaDTO) {

        this.agendaRepository.findById(
                agendaDTO.getCodigo()
        ).ifPresent(idPrograma -> {
                    throw new PacienteJaAgendadoException(agendaDTO.getCodigo());
                }
        );

        return this.agendaRepository.save(
                this.agendaFactory.createFrom(agendaDTO)
        ).getCodigo();
    }
}
