package br.com.projetoclinicamedica.agenda.controller;

import br.com.projetoclinicamedica.agenda.model.Agenda;
import br.com.projetoclinicamedica.agenda.service.AgendaService;
import br.com.projetoclinicamedica.agenda.vo.AgendaVO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Lista todos os exames")
    public List<AgendaVO> listagemExames() {
        return this.agendaService.listAll();
    }

    @GetMapping("{codigoExame}")
    @Operation(summary = " detalha cada agenda")
    public ResponseEntity<Agenda> detalhar(@PathVariable Long codigo)
    {
        return  ResponseEntity.of(this.agendaService.detalhar(codigo));
    }



}
