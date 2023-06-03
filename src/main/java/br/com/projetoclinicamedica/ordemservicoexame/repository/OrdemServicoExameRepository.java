package br.com.projetoclinicamedica.ordemservicoexame.repository;

import br.com.projetoclinicamedica.ordemservicoexame.model.OrdemServicoExame;
import br.com.projetoclinicamedica.ordemservicoexame.vo.OrdemServicoExameVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdemServicoExameRepository extends JpaRepository<OrdemServicoExame, Long> {


    @Query(" SELECT " +
            " new br.com.projetoclinicamedica.ordemservicoexame.vo.OrdemServicoExameVO( " +
            " ordemservicoexame.codigo, " +
            " ordemServico.convenio, " +
            " exame.descricao," +
            " ordemservicoexame.preco" +
            ") " +
            " FROM " +
            " OrdemServicoExame ordemservicoexame " +
            " JOIN " +
            " ordemservicoexame.ordemServico ordemServico" +
            " JOIN " +
            " ordemservicoexame.exame exame"
    )
    List<OrdemServicoExameVO> listAll();


    @Query(" SELECT " +
            " new br.com.projetoclinicamedica.ordemservicoexame.vo.OrdemServicoExameVO( " +
            " ordemservicoexame.codigo, " +
            " ordemServico.convenio, " +
            " exame.descricao," +
            " ordemservicoexame.preco" +
            ") " +
            " FROM " +
            " OrdemServicoExame ordemservicoexame " +
            " JOIN " +
            " ordemservicoexame.ordemServico ordemServico" +
            " JOIN " +
            " ordemservicoexame.exame exame" +
            " WHERE" +
            " ordemservicoexame.codigo=: codigo"

    )
    Optional<OrdemServicoExameVO> findByOne(@Param("codigo") Long codigo);
}
