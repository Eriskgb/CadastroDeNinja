package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Aldeia.AldeiaModel;
import dev.java10x.CadsatroDeNinja.Biju.BijuModel;
import dev.java10x.CadsatroDeNinja.Doujutsu.DoujutsuModel;
import dev.java10x.CadsatroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //anotatio que transforma(cria um relacionamento com o banco de dados) a classe em um DB
@Table(name = "tb_ninja")
@NoArgsConstructor // Criado o construtor vazio
@AllArgsConstructor//Criado os contrutores com varios argumentos
@Data
@ToString(onlyExplicitlyIncluded = true)
public class NinjaModel {

    @Id// anotation para criar um ID automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir a estrategia ao criar o tipo de organizacao do ID
    @ToString.Include
    private long id;
    @ToString.Include
    private String nome;
    @ToString.Include
    @Column(unique = true) //o valor dessa coluna nao pode se repetir
    private String email;
    @ToString.Include
    private String imgUrl;
    @ToString.Include
    private int idade;
    @ToString.Include
    private String rank;

    @ManyToOne// um unico ninja so pode ter apenas um missao por vez
    @JoinColumn(name = "missoes_id")//Foreingkey ou chave estrangeira
    private MissoesModel missao;

    @ManyToOne
    @JoinColumn(name = "jinchuriki_id")
    private BijuModel jinchuriki;

    @ManyToOne
    @JoinColumn(name = "aldeia_id")
    private AldeiaModel aldeia;

    @ManyToOne
    @JoinColumn(name = "doujutsu_id")
    private DoujutsuModel doujutsu;


}


