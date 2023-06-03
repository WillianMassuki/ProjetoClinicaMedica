package br.com.projetoclinicamedica.paciente.controller;


import br.com.projetoclinicamedica.paciente.dto.PacienteDTO;
import br.com.projetoclinicamedica.paciente.service.PacienteService;
import br.com.projetoclinicamedica.paciente.vo.PacienteVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;


    @GetMapping
    @Operation(summary = "Listar tudo")
    List<PacienteVO> findAll()
    {
        return this.pacienteService.listAll();
    }


    @GetMapping("{produtoId}")
    @Operation(summary = "Lista o cupom pelo codigo")
    public ResponseEntity<PacienteVO> detalhar(@PathVariable Long produtoId)
    {
        return  ResponseEntity.of(this.pacienteService.detalhar(produtoId));
    }

    @PostMapping(produces = "application/json")
    @Operation(summary = "Inclui ou atualiza um novo programa")
    public ResponseEntity<Long> salvarPaciente(
            @RequestBody PacienteDTO produtoDTO
    ) {
        return ResponseEntity.ok(this.pacienteService.salvar(produtoDTO));
    }

}
