package br.com.projetoclinicamedica.ordemservico.dto;

import br.com.projetoclinicamedica.medico.model.Medico;
import br.com.projetoclinicamedica.paciente.model.Paciente;
import br.com.projetoclinicamedica.postocoleta.model.PostoColeta;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class
OrdemServicoDTO {

    private Long codigoServico;

    private LocalDateTime data;

    private Paciente paciente;

    private String convenio;

    private PostoColeta postoColeta;

    private Medico medico;
}
