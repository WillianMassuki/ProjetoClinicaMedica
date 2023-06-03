package br.com.projetoclinicamedica.paciente.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class PacienteVO {

       private final Long codigo;
       private final String nome;
       private final String rg;
       private final String cpf;

}
