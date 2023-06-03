package br.com.projetoclinicamedica.postocoleta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
public class PostoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoColeta;

    @Column
    private String descricao;

    @Column
    private String endereco;
}
