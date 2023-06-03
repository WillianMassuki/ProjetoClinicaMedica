package br.com.projetoclinicamedica.paciente.repository;

import br.com.projetoclinicamedica.paciente.model.Paciente;
import br.com.projetoclinicamedica.paciente.vo.PacienteVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.paciente.vo.PacienteVO( " +
            " paciente.codigo, " +
            " paciente.nome, " +
            " paciente.rg," +
            " paciente.cpf" +
            ") " +
            " FROM " +
            " Paciente paciente "
    )
    List<PacienteVO> listAll();

    @Query( " SELECT " +
            " new br.com.projetoclinicamedica.paciente.vo.PacienteVO( " +
            " paciente.codigo, " +
            " paciente.nome, " +
            " paciente.rg," +
            " paciente.cpf" +
            ") " +
            " FROM " +
            " Paciente paciente " +
            " WHERE " +
            " paciente.codigo = :idPaciente"

    )
    Optional<PacienteVO> findByOne(@Param("idPaciente") Long idPaciente);





}
