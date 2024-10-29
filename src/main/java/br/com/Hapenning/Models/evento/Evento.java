package br.com.Hapenning.Models.evento;

import br.com.Hapenning.Models.Endereco;
import br.com.Hapenning.Models.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Embedded
    private Endereco endereco;
    @Temporal(TemporalType.DATE)
    private LocalDate dataEvento;

    @ManyToMany(mappedBy = "eventosInscrito")
    private List<Usuario> participantes;

}
