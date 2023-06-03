package br.com.projetoclinicamedica.exame.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ExameDTO {

    @NotNull
    private Long codigoExame;

    @NotNull
    @Max(100)
    private String descricao;

    @NotNull
    private Double preco;
}
