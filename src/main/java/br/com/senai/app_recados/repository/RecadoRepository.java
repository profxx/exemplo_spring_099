package br.com.senai.app_recados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.app_recados.entity.Recado;

@Repository
public interface RecadoRepository extends JpaRepository<Recado, Long>{

}
