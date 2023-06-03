package br.com.projetoclinicamedica.ordemservicoexame.model;

import br.com.projetoclinicamedica.exame.model.Exame;
import br.com.projetoclinicamedica.ordemservico.model.OrdemServico;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@Entity
public class OrdemServicoExame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @OneToOne
    @JoinColumn(name = "codigoServico")
    private OrdemServico ordemServico;

    @OneToOne
    @JoinColumn(name = "codigoExame")
    private Exame exame;

   @Column
    private Double preco;
}
