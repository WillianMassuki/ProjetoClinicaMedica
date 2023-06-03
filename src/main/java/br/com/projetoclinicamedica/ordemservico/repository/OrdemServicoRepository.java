package br.com.projetoclinicamedica.ordemservico.repository;

import br.com.projetoclinicamedica.ordemservico.model.OrdemServico;
import br.com.projetoclinicamedica.ordemservico.vo.OrdemServicoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.ordemservico.vo.OrdemServicoVO( " +
            " ordemservico.codigoServico, " +
            " ordemservico.data, " +
            " paciente.nome," +
            " ordemservico.convenio," +
            " postoColeta.descricao," +
            " medico.nomeMedico" +
            ") " +
            " FROM " +
            " OrdemServico ordemservico " +
            " JOIN " +
            "ordemservico.paciente paciente " +
            " JOIN " +
            "ordemservico.postoColeta postoColeta " +
            " JOIN " +
            "ordemservico.medico medico "
    )
    List<OrdemServicoVO> listAll();

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.ordemservico.vo.OrdemServicoVO( " +
            " ordemservico.codigoServico, " +
            " ordemservico.data, " +
            " paciente.nome," +
            " ordemservico.convenio," +
            " postoColeta.descricao," +
            " medico.nomeMedico" +
            ") " +
            " FROM " +
            " OrdemServico ordemservico " +
            " JOIN " +
            "ordemservico.paciente paciente " +
            " JOIN " +
            "ordemservico.postoColeta postoColeta " +
            " JOIN " +
            "ordemservico.medico medico " +
            " WHERE " +
            " ordemservico.codigoServico= : codigoServico "

    )
    Optional<OrdemServicoVO> findByOne(@Param("codigoServico") Long codigoServico);




}
