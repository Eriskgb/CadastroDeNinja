package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public NinjaModel listarId (long id){
        return ninjaRepository.findById(id).orElseThrow(()-> new RuntimeException("Ninja nao encontrado" + id));
    }

    //Metodo para deletar registro
    public void deletarId(long id){
        if (!ninjaRepository.existsById(id)) {
            throw new RuntimeException("Ninja nao encontrado" + id);
        }
        ninjaRepository.deleteById(id);
    }
}
