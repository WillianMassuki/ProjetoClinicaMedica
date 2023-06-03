package br.com.projetoclinicamedica.exame.repository;

import br.com.projetoclinicamedica.exame.model.Exame;
import br.com.projetoclinicamedica.exame.vo.ExameVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {

@Query(" SELECT " +
        " new br.com.projetoclinicamedica.exame.vo.ExameVO(" +
        "exame.codigoExame," +
        "exame.descricao," +
        "exame.preco" +
        ") " +
        " FROM " +
        "Exame exame"
    )
    List<ExameVO> findByAll();

    @Query(" SELECT " +
            " new br.com.projetoclinicamedica.exame.vo.ExameVO(" +
            "exame.codigoExame," +
            "exame.descricao," +
            "exame.preco" +
            ") " +
            " FROM " +
            "Exame exame" +
            " WHERE" +
            " exame.codigoExame= : codigoExame"
    )
    Optional<ExameVO> findByOne(@Param("codigoExame") Long codigoExame);





}
