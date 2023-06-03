package br.com.projetoclinicamedica.exame.controller;

import br.com.projetoclinicamedica.exame.dto.ExameDTO;
import br.com.projetoclinicamedica.exame.service.ExameService;
import br.com.projetoclinicamedica.exame.vo.ExameVO;
import br.com.projetoclinicamedica.paciente.dto.PacienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exame")
@RequiredArgsConstructor
public class ExameController {

    private final ExameService exameService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Lista todos os exames")
    public List<ExameVO> listagemExames() {
        return this.exameService.getAll();
    }

    @GetMapping("{codigoExame}")
    @Operation(summary = " Lista de detalhes de cada Exame")
    public ResponseEntity<ExameVO> detalhar(@PathVariable Long codigoExame)
    {
        return  ResponseEntity.of(this.exameService.detalhar(codigoExame));
    }

    @PutMapping(value = "/{codigoExame}", produces = "application/json")
    @Operation(summary = "Atualiza o exame")
    public ResponseEntity<Long> editarExame(
            @PathVariable Long codigoExame,
            @Valid @RequestBody ExameDTO exameDTO
    ) {
        return ResponseEntity.of(this.exameService.alterar(codigoExame, exameDTO));

    }

    @PostMapping(produces = "application/json")
    @Operation(summary = "Inclui um novo exame")
    public ResponseEntity<Long> adicionarExame(
            @RequestBody ExameDTO exameDTO
    ) {
        return ResponseEntity.ok(this.exameService.salvar(exameDTO));
    }



}
