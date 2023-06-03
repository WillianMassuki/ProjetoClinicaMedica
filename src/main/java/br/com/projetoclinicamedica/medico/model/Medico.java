package br.com.projetoclinicamedica.medico.model;

import br.com.projetoclinicamedica.medico.enums.EspecialidadesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoMedico;

    @Column(unique = true)
    private String codigoCrm;

    @Column
    private String nomeMedico;

    @Enumerated(EnumType.STRING)
   private EspecialidadesEnum especialidadesEnum;


}
