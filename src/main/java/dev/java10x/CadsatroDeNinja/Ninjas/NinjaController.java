package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController /* controlador para API Rest*/
@RequestMapping("/ninja") /*Colocar todas as rotas no mesmo lugar*/
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")/*ira pegar o metodo e apresentar*/
    public String boasVindas(){
        return "Seja Bem Vindo, essa e a minha primeira Rota";
    }

    //Criar um ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listarTodos")
    public List<NinjaModel> listarTodos(){
        return ninjaService.listarTodos();
    }

    //Mostar um Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarId(@PathVariable Long id){
        return ninjaService.listarId(id);
    }

    //Atualizar cadastro de Ninja (UPDATE)
    @PutMapping("/atualizar")
    public String atualizarNinja(){
        return "Atualizar Ninja por ID";
    }

    //Deletar Cadsatro de Ninja (DELETE)
    @DeleteMapping("/deletarId")
    public void deletarId(long id){
        ninjaService.deletarId(id);
    }

}
