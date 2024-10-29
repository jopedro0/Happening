package br.com.Hapenning.controllers;

import br.com.Hapenning.Models.evento.Evento;
import br.com.Hapenning.Models.evento.EventoRequest;
import br.com.Hapenning.Models.evento.EventoResponse;
import br.com.Hapenning.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoResponse> criar(@RequestBody EventoRequest eventoRequest,
                                                UriComponentsBuilder uriComponentsBuilder){
        var evento = eventoService.criar(eventoRequest);
        var uri = uriComponentsBuilder.path("/eventos/{id}").buildAndExpand(evento).toUri();
        return ResponseEntity.created(uri).body(new EventoResponse(evento));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> buscarTodos(){
        return ResponseEntity.ok(eventoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
