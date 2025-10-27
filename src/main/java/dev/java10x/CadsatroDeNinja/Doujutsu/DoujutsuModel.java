package dev.java10x.CadsatroDeNinja.Doujutsu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_doujutsu")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoujutsuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "doujutsu")
    @JsonIgnore
    private List<NinjaModel> ninja;
}
