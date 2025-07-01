package dev.java10x.CadsatroDeNinja.Repository;

import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

    NinjaModel findByEmail(String email);
    Optional<NinjaModel> findByNome (String nome);
    List<NinjaModel> findByIdade (int idade);
    List<NinjaModel> findByMissao_Nome (String nomeMissao);
    List<NinjaModel> findByParteNome (String Parte_Nome);
}
