package dev.java10x.CadsatroDeNinja.Aldeia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AldeiaRepository extends JpaRepository<AldeiaModel, Long> {
}
