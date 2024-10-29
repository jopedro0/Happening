package br.com.Hapenning.Models.usuario;

import br.com.Hapenning.Models.Endereco;
import br.com.Hapenning.Models.evento.Evento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Size(min = 8, max = 20)
    private String senha;
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeNascimento;
    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JoinTable(
            name = "eventos_inscrito",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> eventosInscrito;


}
