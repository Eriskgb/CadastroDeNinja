package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;

@Entity //anotatio que transforma a classe em um DB
@Table(name = "tb_cadastro_ninja")
public class NinjaModel {

    @Id// anotatio para criar um ID automatico
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir a estrategia ao criar o tipo de organizacao do ID
    private long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne// um unico ninja so pode ter apenas um missao por vez
    @JoinColumn(name = "missoes_id")//Foreingkey ou chave estrangeira
    private MissoesModel missao;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
