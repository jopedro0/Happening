package br.com.Hapenning.controllers;

import br.com.Hapenning.Models.usuario.Usuario;
import br.com.Hapenning.Models.usuario.UsuarioRequest;
import br.com.Hapenning.Models.usuario.UsuarioResponse;
import br.com.Hapenning.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criar(@RequestBody UsuarioRequest usuarioRequest, UriComponentsBuilder uriComponentsBuilder){
        var usuario = usuarioService.criar(usuarioRequest);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario).toUri();
        return ResponseEntity.created(uri).body(new UsuarioResponse(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
