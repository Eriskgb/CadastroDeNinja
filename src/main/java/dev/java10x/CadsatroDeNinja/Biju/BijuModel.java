package dev.java10x.CadsatroDeNinja.Biju;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_biju")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BijuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int qtdCaldas;
    @OneToMany(mappedBy = "jinchuriki")
    @JsonIgnore
    private List<NinjaModel> jinchurikis;
}
