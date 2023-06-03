package br.com.projetoclinicamedica.paciente.factory;

import br.com.projetoclinicamedica.paciente.dto.PacienteDTO;
import br.com.projetoclinicamedica.paciente.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteFactory {

    public Paciente createFrom(PacienteDTO pacienteDTO)
    {
        return    Paciente.builder()
                .rg(pacienteDTO.getRg())
                .cpf(pacienteDTO.getCpf())
                .nome(pacienteDTO.getNome())
                .codigo(pacienteDTO.getCodigo())
                .build();

    }

}
