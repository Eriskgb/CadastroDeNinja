package dev.java10x.CadsatroDeNinja.Doujutsu;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doujutsus")
public class DoujutsuController {

    private final DoujutsuService doujutsuService;

    public DoujutsuController(DoujutsuService doujutsuService) {
        this.doujutsuService = doujutsuService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar (@RequestBody DoujutsuDTO doujutsuDTO){
        DoujutsuDTO newDoujutsu = doujutsuService.criar(doujutsuDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Doujutsu " + newDoujutsu.getNome() + " Criado com sucesso!");
    }

    @GetMapping("/listarAll")
    public ResponseEntity<?> listarAll(){

        List<DoujutsuDTO> listAll = doujutsuService.listarAll();
        if(listAll.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe registros no banco de dados! ");
        }
        return ResponseEntity.ok(listAll);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarID(@PathVariable long id){
        DoujutsuDTO listarID = doujutsuService.listarID(id);
        if(listarID != null){
            return ResponseEntity.ok(listarID);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi encontrado registro com o ID " + id + " No banco de dados!");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DoujutsuDTO doujutsuDTO){
        DoujutsuDTO doujutsuExists = doujutsuService.update(id,doujutsuDTO);
        if(doujutsuExists != null){
            return ResponseEntity.ok("Atualizando com suscesso o registro " +doujutsuDTO.getNome());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi possivel alterar, nao encontrado registro com o ID " + id + " no banco");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarID(@PathVariable Long id){
        DoujutsuDTO deletar = doujutsuService.listarID(id);
        if(deletar != null){
            doujutsuService.deletar(id);
            return ResponseEntity.ok("Registro " + deletar.getNome() + " deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Não foi possivel deletar, nao encontrado registro com o ID " + id + " no banco de dados");

    }

}
