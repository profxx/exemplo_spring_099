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

import br.com.senai.app_recados.entity.Recado;
import br.com.senai.app_recados.service.RecadoService;

@RestController
@RequestMapping("/recados")
public class RecadoController {

    @Autowired
    private RecadoService recadoService;

    @GetMapping
    public ResponseEntity<List<Recado>> findAll(){
        List<Recado> recados = recadoService.findAll();
        return ResponseEntity.ok().body(recados);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recado> findById(@PathVariable Long id){
        Recado recado = recadoService.findById(id);
        return ResponseEntity.ok().body(recado);
    }
    @PostMapping
    public ResponseEntity<Recado> insertNew(@RequestBody Recado recado){
        Recado recadoInserido = recadoService.insertNew(recado);
        return ResponseEntity.ok().body(recadoInserido);
    }
    @PostMapping
    public ResponseEntity<List<Recado>> insertList(@RequestBody List<Recado> recados){
        List<Recado> recadosInseridos = recadoService.insertList(recados);
        return ResponseEntity.ok().body(recadosInseridos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recado> update(@PathVariable Long id, @RequestBody Recado recado){
        Recado recadoAlterado = recadoService.update(id, recado);
        return ResponseEntity.ok().body(recadoAlterado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        Boolean flag = recadoService.deleteById(id);
        return ResponseEntity.ok().body(flag);
    }
   
}
