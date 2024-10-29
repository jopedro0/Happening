package br.com.Hapenning.Models.evento;

import br.com.Hapenning.Models.Endereco;
import br.com.Hapenning.Models.usuario.Usuario;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record EventoRequest(@NotNull
                            String nome,
                            String descricao,
                            @NotNull
                            Endereco endereco,
                            @NotNull
                            LocalDate dataEvento,
                            List<Usuario> participantes) {
    public Evento toEvento(){
        return new Evento(null, nome(), descricao(), endereco(), dataEvento(), participantes());
    }
}
