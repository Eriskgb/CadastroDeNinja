package dev.java10x.CadsatroDeNinja.Biju;

import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BijuService {

    private final BijuRepository bijuRepository;
    private final BijuMapper bijuMapper;

    //Declarando os contrutores das injecoes de depencencias
    public BijuService(BijuRepository bijuRepository, BijuMapper bijuMapper) {
        this.bijuRepository = bijuRepository;
        this.bijuMapper = bijuMapper;
    }
    //Metodo para criar um novo cadastro
    public BijuDTO criar(BijuDTO bijuDTO){
        BijuModel newBiju = bijuMapper.map(bijuDTO);
        newBiju = bijuRepository.save(newBiju);
        return bijuMapper.map(newBiju);
    }

    //Metodo para listar todos os registros
    public List<BijuDTO> listarTodos(){
        List<BijuModel> bijuAll = bijuRepository.findAll();
        return bijuAll.stream()
                .map(bijuMapper::map)
                .collect(Collectors.toList());
    }
    //Metodo para listar por ID
    public BijuDTO listarID(Long id){
        Optional<BijuModel> bijuID = bijuRepository.findById(id);
        return bijuID.map(bijuMapper::map).orElse(null);
    }
    //Metodo para atualizar
    public BijuDTO update(Long id, BijuDTO bijuDTO){
        Optional<BijuModel> bijuExiste = bijuRepository.findById(id);
        if(bijuExiste.isPresent()){
            BijuModel bijuUpdate = bijuMapper.map(bijuDTO);
            bijuUpdate.setId(id);
            BijuModel bijuSave = bijuRepository.save(bijuUpdate);
            return bijuMapper.map(bijuSave);
        }else{
            return null;
        }
    }

    //Metodo para Deletar
    public void deletar(Long id){
        if(bijuRepository.existsById(id)){
            bijuRepository.deleteById(id);
        }else {
            throw new CadastroNotFound("Nao existe Biju com o ID: "+ id);
        }
    }

}
