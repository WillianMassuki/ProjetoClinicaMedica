package br.com.projetoclinicamedica.postocoleta.controller;

import br.com.projetoclinicamedica.postocoleta.dto.PostoColetaDTO;
import br.com.projetoclinicamedica.postocoleta.service.PostoColetaService;
import br.com.projetoclinicamedica.postocoleta.vo.PostoColetaVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/postoColeta")
@RequiredArgsConstructor
public class PostoColetaController {

    private final PostoColetaService postoColetaService;

    @GetMapping
    @Operation(summary = "Faz a Listagem de todos os postos de coleta")
    public List<PostoColetaVO> listar()
    {
        return postoColetaService.getAll();
    }

    @GetMapping("/{codigo}")
    @Operation(summary = "Detalha cada Posto de Coleta")
    public ResponseEntity<PostoColetaVO> detalharPostoColeta(Long codigo)
    {
        return ResponseEntity.of(postoColetaService.detalhar(codigo));
    }

    @PostMapping
    @Operation(summary = "Adiciona cada Posto de Coleta")
    public ResponseEntity<Long> adicionarPostoColera(@PathVariable PostoColetaDTO postoColetaDTO)
    {
        return ResponseEntity.ok(postoColetaService.salvar(postoColetaDTO));
    }


}
