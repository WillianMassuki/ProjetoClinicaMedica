package br.com.projetoclinicamedica.agenda.model;

import br.com.projetoclinicamedica.medico.model.Medico;
import br.com.projetoclinicamedica.paciente.model.Paciente;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @OneToOne
    @JoinColumn(name = "codigo")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "codigoProfissional")
    private Medico medico;

    @Column
    private LocalDateTime horarioAgendamento;
}
