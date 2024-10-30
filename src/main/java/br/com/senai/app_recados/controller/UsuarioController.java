package br.com.senai.app_recados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.app_recados.entity.Usuario;
import br.com.senai.app_recados.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }
    @PostMapping
    public ResponseEntity<Usuario> insertNew(@RequestBody Usuario usuario){
        Usuario usuarioInserido = usuarioService.insertNew(usuario);
        return ResponseEntity.ok().body(usuarioInserido);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioAlterado = usuarioService.update(id, usuario);
        return ResponseEntity.ok().body(usuarioAlterado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = usuarioService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
}
