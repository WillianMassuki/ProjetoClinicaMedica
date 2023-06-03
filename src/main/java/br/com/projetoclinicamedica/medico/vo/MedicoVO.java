package br.com.projetoclinicamedica.medico.vo;

import br.com.projetoclinicamedica.medico.enums.EspecialidadesEnum;

public record MedicoVO(Long codigoMedico, String codigoCrm, String nome, EspecialidadesEnum especialidadesEnum) {

}
