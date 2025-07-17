package dev.java10x.CadsatroDeNinja.Missoes;
import org.springframework.web.bind.annotation.*;

@RestController /*Controlador para API Rest (ROTAS)*/
@RequestMapping("missoes") //serve para rotear/mapear a API
public class MissoesController {

    //Adicionar novas missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Misao Craida";
    }
    //Alterar missao
    @GetMapping("/listarMissao")
    public String mostrarID(){
        return "Mostrar todas as Missoes por ID";
    }
    //Deletar missao
    @DeleteMapping("/deletar")
    public String deletarMissaoId(){
        return "Missao Deletada";
    }

}
