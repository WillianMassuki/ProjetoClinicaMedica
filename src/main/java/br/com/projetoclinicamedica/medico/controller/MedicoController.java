package br.com.projetoclinicamedica.medico.controller;

import br.com.projetoclinicamedica.medico.dto.MedicoDTO;
import br.com.projetoclinicamedica.medico.service.MedicoService;
import br.com.projetoclinicamedica.medico.vo.MedicoVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/medico")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    @Operation(summary = "Lista todos os medicos cadastrados")
    public List<MedicoVO> listAll()
    {
       return this.medicoService.listAll();

    }

    @GetMapping("{codigoMedico}")
    @Operation(summary = "Lista o cupom pelo codigo")
    public ResponseEntity<MedicoVO> detalhar(@PathVariable Long codigoExame)
    {
        return  ResponseEntity.of(this.medicoService.detalhar(codigoExame));
    }

        @PostMapping(produces = "application/json")
        @Operation(summary = "Inclui ou atualiza um novo programa")
        public ResponseEntity<Long> adicionarExame(
                @RequestBody MedicoDTO medicoDTO
        ) {
            return ResponseEntity.ok(this.medicoService.salvar(medicoDTO));
        }


}
