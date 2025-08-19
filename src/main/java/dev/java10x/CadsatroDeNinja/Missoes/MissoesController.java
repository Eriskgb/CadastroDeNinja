package dev.java10x.CadsatroDeNinja.Missoes;
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



}
