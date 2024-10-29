package br.com.Hapenning.services;

import br.com.Hapenning.Models.usuario.Usuario;
import br.com.Hapenning.Models.usuario.UsuarioRequest;
import br.com.Hapenning.Models.usuario.UsuarioResponse;
import br.com.Hapenning.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criar(UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioRequest.toUsuario();
        return usuarioRepository.save(usuario);
    }

    public UsuarioResponse buscarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioResponse(usuario);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public void delete(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }
}
