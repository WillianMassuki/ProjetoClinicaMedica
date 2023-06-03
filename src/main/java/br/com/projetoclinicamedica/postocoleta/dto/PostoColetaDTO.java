package br.com.projetoclinicamedica.postocoleta.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class PostoColetaDTO {

    private Long codigoColeta;

    @NotNull
    @Max(100)
    private String descricao;

    private String endereco;
}
