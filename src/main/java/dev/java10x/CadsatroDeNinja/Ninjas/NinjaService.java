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
    public NinjasDTO listarId (Long id){
       Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id); //Verificando a existencia do ID passado no paramettro e armazenando na varial
       return ninjaModel.map(ninjasMapper::map).orElse(null); // retornando o valor utilizando streams
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
    public NinjasDTO atualizarId(Long id, NinjasDTO ninjasDTO){
       Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id); //Verificando a existe do ID
       if(ninjaExiste.isPresent()){ //Verificando se o dado esta
           NinjaModel ninjaUpdate = ninjasMapper.map(ninjasDTO); // guardando os dados novo passados pelo usuario
           ninjaUpdate.setId(id); //setando esse novos dados ao ID que foi consultado\
           NinjaModel ninjaSave = ninjaRepository.save(ninjaUpdate); //Salvando os dados novos
           return ninjasMapper.map(ninjaSave);// retornando o novo cadastro atualizado
       }
       return null;
    }

}
