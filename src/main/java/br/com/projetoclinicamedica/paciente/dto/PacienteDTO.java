package br.com.projetoclinicamedica.paciente.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PacienteDTO {

    @NotNull
    private Long codigo;

    @NotNull
    private String nome;

    @NotNull
    @Max(13)
    private String rg;

    @NotNull
    @Max(11)
    private String cpf;

}
