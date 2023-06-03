package br.com.projetoclinicamedica.ordemservicoexame.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/ordemServicoExame")
@RequiredArgsConstructor
public class OrdemServicoExameController {
}
