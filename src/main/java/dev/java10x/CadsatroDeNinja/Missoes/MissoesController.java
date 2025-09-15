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
    public MissoesDTO criar(@RequestBody MissoesDTO missaoDTO){
        return missoesService.criar(missaoDTO);
    }

    //Metodo READ
    @GetMapping("/listarTodos")
    public List<MissoesDTO> listarAll(){
        return missoesService.listarTodos();
    }

    @GetMapping("/listar/{id}")
    public MissoesDTO listarID(@PathVariable Long id){
        return missoesService.listarID(id);
    }

    //Metodos UPDATE
    @PutMapping("/atualizar/{id}")
    public MissoesDTO atualizar(@PathVariable Long id, @RequestBody MissoesDTO missaoDTO){
        return missoesService.atualizar(id,missaoDTO);    }

    //Metodo DELETE
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id){
        missoesService.deletar(id);
    }



}
