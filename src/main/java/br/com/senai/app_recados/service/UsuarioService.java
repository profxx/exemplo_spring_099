package br.com.senai.app_recados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.app_recados.entity.Usuario;
import br.com.senai.app_recados.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario insertNew(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario){
        Usuario usuarioAtual = findById(id);
        usuarioAtual.setUsername(usuario.getUsername());
        usuarioAtual.setRole(usuario.getRole());
        return usuarioRepository.save(usuarioAtual);
    }

    public Boolean deleteById(Long id){
        Usuario usuario = findById(id);
        if (usuario == null){
            return false;
        }else{
            usuarioRepository.deleteById(id);
            return true;
        }
    }

}
