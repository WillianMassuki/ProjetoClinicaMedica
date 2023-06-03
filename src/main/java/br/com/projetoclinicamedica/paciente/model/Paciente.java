package br.com.projetoclinicamedica.paciente.model;

import br.com.projetoclinicamedica.paciente.enuns.ConvenioEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private String nome;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private LocalDateTime dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column
    private ConvenioEnum convenioEnum;

}
