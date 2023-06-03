package br.com.projetoclinicamedica.postocoleta.repository;

import br.com.projetoclinicamedica.postocoleta.model.PostoColeta;
import br.com.projetoclinicamedica.postocoleta.vo.PostoColetaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostoColetaRepository extends JpaRepository<PostoColeta, Long> {

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.postocoleta.vo.PostoColetaVO( " +
            " postocoleta.codigoColeta," +
            " postocoleta.descricao," +
            " postocoleta.endereco" +
            ") " +
            " FROM " +
            " PostoColeta postocoleta "
    )
    List<PostoColetaVO> listAll();

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.postocoleta.vo.PostoColetaVO( " +
            " postocoleta.codigoColeta," +
            " postocoleta.descricao," +
            " postocoleta.endereco" +
            ") " +
            " FROM " +
            " PostoColeta postocoleta " +
            " WHERE " +
            "postocoleta.codigoColeta = :codigoColeta"
    )
    Optional<PostoColetaVO> findByOne(@Param("codigoColeta") Long codigoColeta);
}
