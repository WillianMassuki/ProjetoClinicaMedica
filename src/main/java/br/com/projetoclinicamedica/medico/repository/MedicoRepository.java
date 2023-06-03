package br.com.projetoclinicamedica.medico.repository;

import br.com.projetoclinicamedica.medico.model.Medico;
import br.com.projetoclinicamedica.medico.vo.MedicoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    @Query(" SELECT" +
            " new br.com.projetoclinicamedica.medico.vo.MedicoVO(" +
            " medico.codigoMedico," +
            " medico.codigoCrm," +
            " medico.nomeMedico," +
            " medico.especialidadesEnum" +
            ")" +
            " FROM " +
            "Medico medico"

    )
    List<MedicoVO> findByAll();


    @Query(" SELECT" +
            " new br.com.projetoclinicamedica.medico.vo.MedicoVO(" +
            " medico.codigoMedico," +
            " medico.codigoCrm," +
            " medico.nomeMedico," +
            " medico.especialidadesEnum" +
            ")" +
            " FROM " +
            " Medico medico" +
            " WHERE " +
            " medico.codigoMedico= :idCodigoMedico"

    )
    Optional<MedicoVO> findByOne(@Param("idCodigoMedico") Long idCodigoMedico);


}
