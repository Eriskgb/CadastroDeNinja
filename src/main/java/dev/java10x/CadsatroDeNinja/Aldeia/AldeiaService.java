package dev.java10x.CadsatroDeNinja.Aldeia;
import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AldeiaService {

    private final AldeiaRepository aldeiaRepository;
    private final AldeiaMapper aldeiaMapper;

    public AldeiaService(AldeiaRepository aldeiaRepository, AldeiaMapper aldeiaMapper) {
        this.aldeiaRepository = aldeiaRepository;
        this.aldeiaMapper = aldeiaMapper;
    }

    //Metodo CREATE
    public AldeiaDTO criar(AldeiaDTO aldeiaDTO){
        AldeiaModel aldeia = aldeiaMapper.map(aldeiaDTO); //Mapweando o AldeiaModel com AldeiaDTO
        aldeia =  aldeiaRepository.save(aldeia);
        return aldeiaMapper.map(aldeia);
    }
    //Metodo READ
    public List<AldeiaDTO> listarAll(){
        List<AldeiaModel> aldeiaAll = aldeiaRepository.findAll();
        return aldeiaAll.stream()
                .map(aldeiaMapper::map)
                .collect(Collectors.toList());
    }
    public AldeiaDTO listarID(Long id) {
        Optional<AldeiaModel> aldeiaID = aldeiaRepository.findById(id);
        return aldeiaID.map(aldeiaMapper::map).orElse(null);
    }
    //Metodo UPDATE
    public AldeiaDTO update(Long id, AldeiaDTO aldeiaDTO) {
        Optional<AldeiaModel> aldeiaExists = aldeiaRepository.findById(id);
        if(aldeiaExists.isPresent()){
            AldeiaModel aldeiaUpdate = aldeiaMapper.map(aldeiaDTO);
            aldeiaUpdate.setId(id);
            AldeiaModel aldeiaSave = aldeiaRepository.save(aldeiaUpdate);
            return aldeiaMapper.map(aldeiaSave);
        }
        return null;
    }
    //DELETE
    public void deletar(Long id){
        if(aldeiaRepository.existsById(id)){
           aldeiaRepository.deleteById(id);
        }else{
            throw new CadastroNotFound("Aldeia com ID " + id + " excluida com sucesso");
        }
    }

}
