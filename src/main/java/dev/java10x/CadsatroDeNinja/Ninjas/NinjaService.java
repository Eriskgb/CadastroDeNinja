package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    //Injecao de dependencia
    private NinjaRepository ninjaRepository;
    private NinjasMapper ninjasMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjasMapper ninjasMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjasMapper = ninjasMapper;
    }

    //metodo para consultar todos os ninjas do cadastro
    public List<NinjaModel> listarTodos(){
        return ninjaRepository.findAll();
    }

    //Metodo para listsar os ninjas por ID
    public NinjaModel listarId (Long id){
       return ninjaRepository.findById(id).orElse(null);

    }

    //Meotod para criar novo ninja
    public NinjasDTO criarNinja(NinjasDTO ninjaDTO){
        NinjaModel ninja = ninjasMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjasMapper.map(ninja);
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
