package br.com.projetoclinicamedica.ordemservico.model;

import br.com.projetoclinicamedica.medico.model.Medico;
import br.com.projetoclinicamedica.paciente.model.Paciente;
import br.com.projetoclinicamedica.postocoleta.model.PostoColeta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoServico;

    @Column
    private LocalDateTime data;

    @OneToOne
    @JoinColumn(name = "codigo")
    private Paciente paciente;

    @Column
    private String convenio;

    @OneToOne
    @JoinColumn(name = "codigoColeta" )
    private PostoColeta postoColeta;

    @OneToOne
    @JoinColumn(name = "codigoMedico")
    private Medico medico;
}
