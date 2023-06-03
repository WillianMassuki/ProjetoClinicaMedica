package br.com.projetoclinicamedica.agenda.repository;

import br.com.projetoclinicamedica.agenda.model.Agenda;
import br.com.projetoclinicamedica.agenda.vo.AgendaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.agenda.vo.AgendaVO( " +
            " agenda.codigo," +
            " paciente.nome," +
            " medico.nomeMedico," +
            " agenda.horarioAgendamento" +
            ") " +
            " FROM " +
            " Agenda agenda " +
            "JOIN" +
            " agenda.paciente paciente" +
            " JOIN " +
            " agenda.medico medico"
    )
    List<AgendaVO> listAll();

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.agenda.vo.AgendaVO( " +
            " agenda.codigo," +
            " paciente.nome," +
            " medico.nomeMedico," +
            " agenda.horarioAgendamento" +
            ") " +
            " FROM " +
            " Agenda agenda " +
            "JOIN" +
            " agenda.paciente paciente" +
            " JOIN " +
            " agenda.medico medico" +
            " WHERE " +
            " agenda.codigo= :codigo"
    )
    Optional<AgendaVO> findByOne(@Param("codigo") Long codigo);

}
