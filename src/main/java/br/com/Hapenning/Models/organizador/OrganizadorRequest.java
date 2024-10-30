package br.com.Hapenning.Models.organizador;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record OrganizadorRequest(@NotNull
                                 String nome,
                                 @NotNull
                                 @Email
                                 String email,
                                 @NotNull
                                 String senha,
                                 String cnpj) {
    public Organizador toOrganizador(){
        return new Organizador(null, nome(), email(), senha(), cnpj());

    }
}
