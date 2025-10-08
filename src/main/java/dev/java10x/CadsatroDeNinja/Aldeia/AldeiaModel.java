package dev.java10x.CadsatroDeNinja.Aldeia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_aldeia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AldeiaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String pais;

    @Column(name = "ninja")
    @OneToMany(mappedBy = "aldeia")
    @JsonIgnore
    private List<NinjaModel> ninja;
}
