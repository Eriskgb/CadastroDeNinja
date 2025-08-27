package dev.java10x.CadsatroDeNinja.Missoes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController /*Controlador para API Rest (ROTAS)*/
@RequestMapping("/missoes") //serve para rotear/mapear a API
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Metodo CREATE
    @PostMapping("/criar")
    public MissoesModel criar(@RequestBody MissoesModel missao){
        return missoesService.criar(missao);
    }

    //Metodo READ
    @GetMapping("/listarTodos")
    public List<MissoesModel> listarAll(){
        return missoesService.listarTodos();
    }
    //Metodos UPDATE
    @PutMapping("/atualizar/{id}")
    public MissoesModel atualizar(@PathVariable Long id, @RequestBody MissoesModel missao){
        return missoesService.atualizar(id,missao);
    }

    //Metodo DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        missoesService.deletar(id);
    }



}
