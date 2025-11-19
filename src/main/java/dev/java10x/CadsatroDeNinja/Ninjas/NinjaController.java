package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController /* controlador para API Rest*/
@RequestMapping("/ninjas") /*Colocar todas as rotas no mesmo lugar*/
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Criar um ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjasDTO ninja){//
        NinjasDTO ninjasDTO = ninjaService.criarNinja(ninja); // adicionado o dados passados no parametros para variavel do tipo NinjaDTO
        return ResponseEntity.status(HttpStatus.CREATED) // retornando para o usuario o StatusHttp Create, com codigo 201 mais msg
                .body("Ninja: " + ninjasDTO.getNome() + " Criado com sucesso, ID: " + ninjasDTO.getId());
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/listarTodos")
    public ResponseEntity<List<NinjasDTO>> listarTodos(){
        List<NinjasDTO> ninjaAll = ninjaService.listarTodos();
        return ResponseEntity.ok(ninjaAll);
    }

    //Mostar um Ninja por ID (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id){// O ResponseEntity ao inves de retornar uma String(MSG deve deixar ? para especificar na msg de sucesso e nao encontrado
        NinjasDTO ninjasDTO = ninjaService.listarId(id); // armazenar a consulta em variavel do tipo NinjaDTO
        if(ninjasDTO != null){// fazer verificacao da existencia
            return ResponseEntity.ok(ninjasDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " ano encontrado");
        }
    }

    //Atualizar cadastro de Ninja (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarID(@PathVariable Long id, @RequestBody NinjasDTO ninja){
        NinjasDTO ninjasExists = ninjaService.atualizarId(id,ninja); // verificando a existencia e armazenando no variavel
        if(ninjasExists != null){ // validando a existencia
            return ResponseEntity.ok(ninjasExists); // retornando para o suario o valor com msg de sucesso
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // retornando para usuario que nao foi encontrado
                    .body("Nao foi possivel atualizar ninja com ID: " + id + " , nao existe no banco de dados");
        }
    }

    //Deletar Cadsatro de Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarId(@PathVariable Long id){
        if(ninjaService.listarId(id) != null){
            ninjaService.deletarId(id);
            return ResponseEntity.ok("Ninja com ID : " + id + " deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + " nao encontrado");
        }

    }


}
