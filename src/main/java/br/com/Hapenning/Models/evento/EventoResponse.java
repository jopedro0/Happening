package br.com.Hapenning.Models.evento;

import br.com.Hapenning.Models.Endereco;
import br.com.Hapenning.Models.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public record EventoResponse(Long id,
                             String nome,
                             String descricao,
                             Endereco endereco,
                             LocalDate dataEvento,
                             List<Usuario> participantes) {
    public EventoResponse(Evento evento){
        this(evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getEndereco(),
                evento.getDataEvento(),
                evento.getParticipantes());
    }
}
