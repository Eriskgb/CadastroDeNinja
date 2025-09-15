package dev.java10x.CadsatroDeNinja.Missoes;
import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;
    MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Metodo CREATE
    public MissoesDTO criar(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO); // Criando estancia MissoesModel e mapeando para receber missaoDTO
        missao = missoesRepository.save(missao);//Pegando os dados da Variavel missao e salvando no bancos
        return missoesMapper.map(missao);//retornando para usuario
    }

    //Metodo READ
    public List<MissoesDTO> listarTodos(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Metodo para Listar por ID
    public MissoesDTO listarID(Long id){
        Optional<MissoesModel> missaoID = missoesRepository.findById(id);
        return missaoID.map(missoesMapper::map).orElse(null);
    }

    //Metodo Update
    public MissoesDTO atualizar(Long id, MissoesDTO missaoDTO){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        if(missao.isPresent()){
            MissoesModel missaoUpdate = missoesMapper.map(missaoDTO);
            missaoUpdate.setId(id);
            MissoesModel missaoSave = missoesRepository.save(missaoUpdate);
            return missoesMapper.map(missaoSave);
        }
        return null;
    }

    //Metodo para Deletar
    public void deletar(Long id) {
        if(missoesRepository.existsById(id)){
            missoesRepository.deleteById(id);
        }else {
            throw new CadastroNotFound("Missao nao encontrada");
        }

    }
}
