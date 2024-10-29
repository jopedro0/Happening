package br.com.Hapenning.repositories;

import br.com.Hapenning.Models.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
