package dev.java10x.CadsatroDeNinja.Missoes;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missao") // Uma missao pode ter varios Ninjas | mappedBy mapenado a coluna da outra tabela.
    private List<NinjaModel> ninjas;

}
