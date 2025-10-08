package dev.java10x.CadsatroDeNinja.Aldeia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aldeia")
public class AldeiaController {

    private AldeiaService aldeiaService;

    public AldeiaController(AldeiaService aldeiaService) {
        this.aldeiaService = aldeiaService;
    }

    //CREATE
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody AldeiaDTO aldeiaDTO){
        AldeiaDTO newAldeia = aldeiaService.criar(aldeiaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cadastro da aldeia: " + newAldeia.getNome() + " criado com sucesso");
    }
    //READ
    @GetMapping("/listarTodos")
    public ResponseEntity<List<AldeiaDTO>> listarTodos(){
        List<AldeiaDTO> listarDTO = aldeiaService.listarAll();
         return ResponseEntity.ok(listarDTO);
    }
    //Listar por id
    @GetMapping("/listarID/{id}")
    public ResponseEntity<?> listarID(@PathVariable Long id){
        AldeiaDTO aldeiaID = aldeiaService.listarID(id);
        if(aldeiaID != null){
            return ResponseEntity.ok(aldeiaID);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nao existe registro com o ID" + id + " no sistema");
    }
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody AldeiaDTO aldeiaDTO){
        if(aldeiaService.update(id,aldeiaDTO) != null){
            return ResponseEntity.ok(aldeiaDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao foi encontrado cadastro com o ID " + id);
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        AldeiaDTO aldeiaDeletar = aldeiaService.listarID(id);
        if(aldeiaDeletar != null){
            aldeiaService.deletar(id);
            return ResponseEntity.ok("Deletado aldeia " + aldeiaDeletar.getNome() + " com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("nao foi possivel exlcuir aldeia " + aldeiaDeletar.getNome() + " Nao existe no sistema");
    }

}