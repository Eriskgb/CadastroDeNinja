package dev.java10x.CadsatroDeNinja;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* controlador para API Rest*/
//@RequestMapping("/boasVindas") /*Colocar todas as rotas no mesmo lugar*/
public class Controller {

    @GetMapping("/boasVindas")/*ira pegar o metodo e apresentar*/
    public String boasVindas(){
        return "Seja Bem Vindo, essa e a minha primeira Rota";
    }
    @GetMapping("/consultaNinja")
    public String consultaNinja(){
        return "Essa Rota e para consulta os Cadastro dos Ninjas";
    }

}
