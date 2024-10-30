package br.com.senai.app_recados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.app_recados.entity.Recado;
import br.com.senai.app_recados.repository.RecadoRepository;

@Service
public class RecadoService {

    @Autowired
    private RecadoRepository recadoRepository;

    // Find all
    public List<Recado> findAll(){
        return recadoRepository.findAll();
    }

    // Find by id
    public Recado findById(Long id){
        return recadoRepository.findById(id).orElse(null);
    }

    // Insert New Recado
    public Recado insertNew(Recado recado){
        recado.setLido(false);
        return recadoRepository.save(recado);
    }
    // Insert List
    public List<Recado> insertList(List<Recado> recados){
        return recadoRepository.saveAll(recados);
    }

    // Update Recado
    public Recado update(Long id, Recado recadoAlterado){
        Recado recadoAtual = findById(id);
        recadoAtual.setMensagem(recadoAlterado.getMensagem());
        recadoAtual.setLido(recadoAlterado.getLido());
        return recadoRepository.save(recadoAtual);
    }

    // Delete Recado
    public Boolean deleteById(Long id){
        Recado recado = findById(id);
        if (recado == null){
            return false;
        }else{
            recadoRepository.deleteById(id);
            return true;
        }
    }

}
