package br.com.Hapenning.controllers;

import br.com.Hapenning.Models.organizador.OrganizadorRequest;
import br.com.Hapenning.Models.organizador.OrganizadorResponse;
import br.com.Hapenning.Models.usuario.UsuarioResponse;
import br.com.Hapenning.services.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/organizadores")
public class OrganizadorController {
    @Autowired
    private OrganizadorService organizadorService;

    @PostMapping
    public ResponseEntity<OrganizadorResponse>criar (@RequestBody OrganizadorRequest organizadorRequest, UriComponentsBuilder uriComponentsBuilder){
        var organizador = organizadorService.criar(organizadorRequest);
        var uri = uriComponentsBuilder.path("/organizadores/{id}").buildAndExpand(organizador).toUri();
        return ResponseEntity.created(uri).body(new OrganizadorResponse(organizador));
    }



}
