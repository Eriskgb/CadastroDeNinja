package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController /* controlador para API Rest*/
@RequestMapping("/ninjas") /*Colocar todas as rotas no mesmo lugar*/
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Criar um ninja (CREATE)
    @PostMapping("/criar")
    public NinjasDTO criarNinja(@RequestBody NinjasDTO ninja){
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
    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizarID(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return ninjaService.atualizarId(id,ninja);
    }

    //Deletar Cadsatro de Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarId(@PathVariable Long id){
        ninjaService.deletarId(id);
    }


}
