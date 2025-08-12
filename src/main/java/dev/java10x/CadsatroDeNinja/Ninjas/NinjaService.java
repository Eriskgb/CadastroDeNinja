package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    //metodo para consultar todos os ninjas do cadastro
    public List<NinjaModel> listarTodos(){
        return ninjaRepository.findAll();
    }

    //Metodo para listsar os ninjas por ID
    public NinjaModel listarId (Long id){
        Optional<NinjaModel>  ninjaId = ninjaRepository.findById(id);
        return ninjaId.orElseThrow(() -> new RuntimeException("Ninja nao encontrado"));
    }

    //Meotod para criar nono ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Metodo para deletar registro
    public void deletarId(long id){
        if (!ninjaRepository.existsById(id)) {
            throw new RuntimeException("Ninja nao encontrado" + id);
        }
        ninjaRepository.deleteById(id);
    }
}
