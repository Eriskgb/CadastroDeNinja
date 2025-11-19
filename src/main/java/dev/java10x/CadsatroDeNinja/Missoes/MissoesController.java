package dev.java10x.CadsatroDeNinja.Missoes;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjasDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController /*Controlador para API Rest (ROTAS)*/
@RequestMapping("/missoes") //serve para rotear/mapear a API
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Metodo CREATE
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody MissoesDTO missaoDTO){
        MissoesDTO newMissao = missoesService.criar(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao " + newMissao.getNome() + " criado com sucesso");
    }

    //Metodo READ
    @GetMapping("/listarTodos")
    public ResponseEntity<List<MissoesDTO>> listarAll()
    {
        List<MissoesDTO> missaoAll = missoesService.listarTodos();
        return ResponseEntity.ok(missaoAll);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarID(@PathVariable Long id){

        if(missoesService.listarID(id) != null){
            MissoesDTO missoesDTO = missoesService.listarID(id);
            return ResponseEntity.ok(missoesDTO);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao foi possivel localizar a Missao com o ID: " + id);
        }
    }

    //Metodos UPDATE
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody MissoesDTO missaoDTO){
        MissoesDTO missaoUpdate = missoesService.atualizar(id,missaoDTO);
        if(missaoUpdate != null){
            return  ResponseEntity.ok(missaoUpdate);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao foi possivel atualizar missao com ID: " + id + " nao existe em nosso registros");
        }
    }

    //Metodo DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){

        if(missoesService.listarID(id) != null){
            missoesService.deletar(id);
            return ResponseEntity.ok("Missao com ID: " + id + " deletado com sucessoi");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao foi possivel exlcuir misaso com ID: " + id + " nao existe em nossos registros");
        }

    }



}


