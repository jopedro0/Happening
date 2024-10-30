package br.com.Hapenning.repositories;

import br.com.Hapenning.Models.organizador.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long> {
    boolean existsByEmail(String email);
}
