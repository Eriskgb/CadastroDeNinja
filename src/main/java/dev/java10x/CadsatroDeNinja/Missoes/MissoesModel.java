package dev.java10x.CadsatroDeNinja.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missao") // Uma missao pode ter varios Ninjas | mappedBy mapenado a coluna da outra tabela.
    @JsonIgnore // ignora o loop de serializacao
    private List<NinjaModel> ninjas;

}
