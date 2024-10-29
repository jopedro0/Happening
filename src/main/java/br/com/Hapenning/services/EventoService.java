package br.com.Hapenning.services;

import br.com.Hapenning.Models.evento.Evento;
import br.com.Hapenning.Models.evento.EventoRequest;
import br.com.Hapenning.Models.evento.EventoResponse;
import br.com.Hapenning.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Evento criar(EventoRequest eventoRequest){
        Evento evento = eventoRequest.toEvento();
        return eventoRepository.save(evento);
    }

    public EventoResponse buscarPorId(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        return new EventoResponse(evento);
    }

    public List<Evento> buscarTodos(){
        return eventoRepository.findAll();
    }

    public void delete(Long id){
        if (eventoRepository.existsById(id)){
            eventoRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Evento não encontrado");
        }
    }

}
