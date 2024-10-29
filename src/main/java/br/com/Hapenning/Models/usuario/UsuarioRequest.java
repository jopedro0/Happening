package br.com.Hapenning.Models.usuario;

import br.com.Hapenning.Models.Endereco;
import br.com.Hapenning.Models.evento.Evento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record UsuarioRequest(@NotNull @NotBlank
                             String nome,
                             @NotNull @Email
                             String email,
                             @NotNull
                             String senha,
                             LocalDate dataDeNascimento,
                             Endereco endereco,
                             List<Evento> eventosInscrito) {
    public Usuario toUsuario(){
        return new Usuario(null, nome(), email(), senha(), dataDeNascimento(), endereco(), eventosInscrito());
    }
}
