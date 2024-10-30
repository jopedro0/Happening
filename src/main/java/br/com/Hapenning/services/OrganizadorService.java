package br.com.Hapenning.services;

import br.com.Hapenning.Models.organizador.Organizador;
import br.com.Hapenning.Models.organizador.OrganizadorRequest;
import br.com.Hapenning.Models.organizador.OrganizadorResponse;
import br.com.Hapenning.Models.usuario.Usuario;
import br.com.Hapenning.repositories.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorService {
    @Autowired
    private OrganizadorRepository organizadorRepository;

    public Organizador criar(OrganizadorRequest organizadorRequest){
        Organizador organizador = organizadorRequest.toOrganizador();
        if(organizadorRepository.existsByEmail(organizadorRequest.email())){
            throw  new RuntimeException("Email já em uso");
        }
        return organizadorRepository.save(organizador);
    }

    public OrganizadorResponse buscarPorId(Long id){
        Organizador organizador = organizadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new OrganizadorResponse(organizador);
    }

    public List<Organizador> buscarTodos(){
        return organizadorRepository.findAll();
    }

    public void delete(Long id) {
        if (organizadorRepository.existsById(id)) {
            organizadorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
