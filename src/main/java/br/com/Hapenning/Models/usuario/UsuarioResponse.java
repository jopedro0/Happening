package br.com.Hapenning.Models.usuario;

import br.com.Hapenning.Models.Endereco;

import java.time.LocalDate;

public record UsuarioResponse(Long id,
                              String nome,
                              String email,
                              LocalDate dataDeNascimento,
                              Endereco endereco) {
    public UsuarioResponse(Usuario usuario){
        this(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataDeNascimento(),
                usuario.getEndereco());
    }
}
