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
}
