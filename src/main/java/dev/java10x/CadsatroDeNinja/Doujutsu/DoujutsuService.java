package dev.java10x.CadsatroDeNinja.Doujutsu;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

@Service
public class DoujutsuService {

    DoujutsuRepository doujutsuRepository;
    DoujutsuMapper doujutsuMapper;

    public DoujutsuService(DoujutsuRepository doujutsuRepository, DoujutsuMapper doujutsuMapper) {
        this.doujutsuRepository = doujutsuRepository;
        this.doujutsuMapper = doujutsuMapper;
    }

    //Create
    public DoujutsuDTO criar(DoujutsuDTO doujutsuDTO){
        DoujutsuModel newDoujutsu = doujutsuMapper.map(doujutsuDTO);
        DoujutsuModel newSave = doujutsuRepository.save(newDoujutsu);
        return doujutsuMapper.map(newSave);
    }

    //Read
    public List<DoujutsuDTO> listarAll(){
        List<DoujutsuModel> listar = doujutsuRepository.findAll();
        return listar.stream()//Converte a lista em um sequencia de elementros que permite aplicar operações funcinais
                     .map(doujutsuMapper::map)//Mapea e converte os elementos Model em DTO
                     .collect(toList());//Transforma os elemtros em uma lista DTO.
    }

    //Read id
    public DoujutsuDTO listarID (Long id){
        Optional<DoujutsuModel> listarID = doujutsuRepository.findById(id);
        return listarID.map(doujutsuMapper::map).orElse(null);
    }

    //Update
    public DoujutsuDTO update(Long id, DoujutsuDTO doujutsuDTO){
        Optional<DoujutsuModel> doujutsuID = doujutsuRepository.findById(id);
        if(doujutsuID.isPresent()){
            DoujutsuModel updateDoujutsu = doujutsuMapper.map(doujutsuDTO);
            updateDoujutsu.setId(id);
            DoujutsuModel saveDoujutsu = doujutsuRepository.save(updateDoujutsu);
            return doujutsuMapper.map(saveDoujutsu);

        }
        return null;
    }

    //Delete
    public void deletar(Long id){
        if(doujutsuRepository.existsById(id)){
            doujutsuRepository.deleteById(id);
        }
    }
}

