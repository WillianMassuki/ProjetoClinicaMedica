package br.com.projetoclinicamedica.medico.factory;

import br.com.projetoclinicamedica.medico.dto.MedicoDTO;
import br.com.projetoclinicamedica.medico.model.Medico;
import org.springframework.stereotype.Component;

@Component
public class MedicoFactory {

    public Medico createFrom(MedicoDTO profissionalDTO)
    {
        return    Medico.builder()
                .nomeMedico(profissionalDTO.getNome())
                .codigoCrm(profissionalDTO.getCodigoCrm())
                .especialidadesEnum(profissionalDTO.getEspecialidadesEnum())
                .build();

    }
}
