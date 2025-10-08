package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Aldeia.AldeiaModel;
import dev.java10x.CadsatroDeNinja.Biju.BijuModel;
import dev.java10x.CadsatroDeNinja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjasDTO {

    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private MissoesModel missao;
    private BijuModel jinchuriki;
    private AldeiaModel aldeia;
}
