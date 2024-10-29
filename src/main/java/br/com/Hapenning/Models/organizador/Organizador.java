package br.com.Hapenning.Models.organizador;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organizador {
    @Id
    @CNPJ
    private String cnpj;
}
