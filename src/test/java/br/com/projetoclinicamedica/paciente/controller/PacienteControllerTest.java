package br.com.projetoclinicamedica.paciente.controller;

import br.com.projetoclinicamedica.paciente.dto.PacienteDTO;
import br.com.projetoclinicamedica.paciente.service.PacienteService;
import br.com.projetoclinicamedica.paciente.vo.PacienteVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class PacienteControllerTest {

    public static final Long codigo = 1L;
    public static final String NOME = "Willian";
    public static final String EMAIL = "willianmassuki@gmail.com";
    public static final String RG = "180747563";

    public static final String CPF = "45986344995";


    public static final int INDEX = 0;

    @InjectMocks
    private PacienteController pacienteController;

    @Mock
    private PacienteService pacienteService;

    @Mock
    private ModelMapper mapper;

    private PacienteVO pacienteVO;

    private PacienteDTO pacienteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        starPaciente();
    }

    @Test
    void whenFindByIdThenReturnSucess()
    {
        when(pacienteService.detalhar(anyLong())).thenReturn(Optional.ofNullable(pacienteVO));
        when(mapper.map(any(), any())).thenReturn(pacienteVO);

        ResponseEntity<PacienteVO> response = pacienteController.detalhar(codigo);

        assertNotNull(response);
      //  assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
     //   assertEquals(PacienteVO.class, Objects.requireNonNull(response.getBody()).getClass());
      //  assertEquals(PacienteVO.class, response.getBody().getCodigo());
       // assertEquals(codigo, response.getBody().getCodigo());
    }

    @Test
    void whenFindAllThenReturnAListOfPacienteVO()
    {
        when(pacienteService.listAll()).thenReturn(List.of(pacienteVO));
        when(mapper.map(any(), any())).thenReturn(pacienteVO);

        List<PacienteVO> response = pacienteController.findAll();

        assertNotNull(response);

    }

    @Test
    void whenCreateThenReturnCreated()
    {
        when(pacienteService.salvar(any())).thenReturn(codigo);

        ResponseEntity<Long> response = pacienteController.salvarPaciente(pacienteDTO);

        assertEquals(ResponseEntity.class, response.getClass());
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
   //     assertNotNull(response.getHeaders().get("Location"));
    }

    private void starPaciente()
    {
        pacienteVO = new PacienteVO(codigo, NOME, RG, CPF );
        pacienteDTO = new PacienteDTO(codigo, NOME, RG, CPF );
    }

}
