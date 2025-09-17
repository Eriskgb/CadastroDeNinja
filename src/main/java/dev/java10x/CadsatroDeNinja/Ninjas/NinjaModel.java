package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //anotatio que transforma(cria um relacionamento com o banco de dados) a classe em um DB
@Table(name = "tb_ninja")
@NoArgsConstructor // Criado o construtor vazio
@AllArgsConstructor//Criado os contrutores com varios argumentos
@Data
public class NinjaModel {

    @Id// anotation para criar um ID automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir a estrategia ao criar o tipo de organizacao do ID
    private long id;
    private String nome;
    @Column(unique = true) //o valor dessa coluna nao pode se repetir
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    @ManyToOne// um unico ninja so pode ter apenas um missao por vez
    @JoinColumn(name = "missoes_id")//Foreingkey ou chave estrangeira
    private MissoesModel missao;
}
