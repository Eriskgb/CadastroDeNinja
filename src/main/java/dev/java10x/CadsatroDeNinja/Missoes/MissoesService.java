package dev.java10x.CadsatroDeNinja.Missoes;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Metodo CREATE
    public MissoesModel criar(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Metodo READ
    public List<MissoesModel> listarTodos(){
        return missoesRepository.findAll();
    }
}
