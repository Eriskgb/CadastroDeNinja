package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import org.springframework.stereotype.Service;
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

    //Meotod para criar novo ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Metodo para deletar registro
    public void deletarId(Long id){
        if(ninjaRepository.existsById(id)){
            ninjaRepository.deleteById(id);
        }else{
            throw new CadastroNotFound("Cadastro de Ninha nao encontrado");
        }
    }

    //Metodo para ataualizar um cadastro ja existesnte
    public NinjaModel atualizarId(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

}
