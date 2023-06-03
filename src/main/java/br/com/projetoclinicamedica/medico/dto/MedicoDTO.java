package br.com.projetoclinicamedica.medico.dto;

import br.com.projetoclinicamedica.medico.enums.EspecialidadesEnum;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class MedicoDTO {


    private Long codigo;

    private String codigoCrm;

    private String nome;

    private EspecialidadesEnum especialidadesEnum;
}
