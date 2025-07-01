package dev.java10x.CadsatroDeNinja.Repository;

import dev.java10x.CadsatroDeNinja.Missoes.MissoesModel;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MissoesRepository extends JpaRepository<MissoesModel, Integer> {

    Optional<MissoesModel> findByNome (String nome);
    List<MissoesModel> findByNomeContaining (String nome);
    List<MissoesModel> findByDificuldade (String dificuldade);
    List<MissoesModel> findByDificuldadeOrderByDificuldadeAsc();

}
