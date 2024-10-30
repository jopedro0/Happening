package br.com.Hapenning.Models.organizador;

public record OrganizadorResponse(Long id,
                                  String nome,
                                  String email,
                                  String cnpj) {
    public OrganizadorResponse(Organizador organizador){
        this(organizador.getId(),
                organizador.getNome(),
                organizador.getEmail(),
                organizador.getCnpj());
    }
}
