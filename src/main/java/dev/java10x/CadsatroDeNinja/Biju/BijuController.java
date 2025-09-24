package dev.java10x.CadsatroDeNinja.Biju;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biju")
public class BijuController {

     BijuService bijuService;

    public BijuController(BijuService bijuService) {
        this.bijuService = bijuService;
    }

    @GetMapping("/Ola")
    public String Ola(){
        return "Ola, mundo";
    }

    //CREATE
    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody BijuDTO bijuDTO){
        BijuDTO newBiju = bijuService.criar(bijuDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Biju "+ newBiju.getNome() + " cadastrado com sucesso");
    }
    //READ -- Listar todos
    @GetMapping("/listarTodos")
    public ResponseEntity<List<BijuDTO>> listarTodos(){
        List<BijuDTO> bijuAll = bijuService.listarTodos();
            return ResponseEntity.ok(bijuAll);
    }
        //Lista por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarId(@PathVariable Long id){
       BijuDTO bijuID = bijuService.listarID(id);
       if( bijuID != null){
           return ResponseEntity.ok(bijuID);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Nao foi encontrado Biju com o ID: "+ id );
       }
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        if(bijuService.listarID(id)!= null){
            bijuService.deletar(id);
            return ResponseEntity.ok("Nija de ID "+ id + " deletado com suscesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao existe biju com o ID "+ id + " cadastrado");
        }
    }
}
