package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController /* controlador para API Rest*/
@RequestMapping("/boasVindas") /*Colocar todas as rotas no mesmo lugar*/
public class NinjaController {

    @GetMapping("/boasVindas")/*ira pegar o metodo e apresentar*/
    public String boasVindas(){
        return "Seja Bem Vindo, essa e a minha primeira Rota";
    }

    //Criar um ninja (CREATE)
    @PostMapping("/CriarNinja")
    public String criarNinja(){
        return "Cadastro um novo Ninja";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/MostrarTodos")
    public String mostrarTodosNinjas(){
        return "Mostrar todos os Ninjas";
    }

    //Mostar um Ninja por ID (READ)
    @GetMapping("/MostrarID")
    public String mostrarNinjasId(){
        return "Mostrar ninjas por ID";
    }

    //Atualizar cadastro de Ninja (UPDATE)
    @PutMapping("/AtualizarNinja")
    public String atualizarNinja(){
        return "Atualizar Ninja por ID";
    }
    //Deletar Cadsatro de Ninja (DELETE)
    @DeleteMapping("/DeletarNinja")
    public String deletarNinjaId(){
        return "Deletar ninja por ID";
    }

}
