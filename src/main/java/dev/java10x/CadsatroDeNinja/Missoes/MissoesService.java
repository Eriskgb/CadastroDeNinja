package dev.java10x.CadsatroDeNinja.Missoes;
import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Metodo CREATE
    public MissoesModel criar(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Metodo READ
    public List<MissoesModel> listarTodos(){
        return missoesRepository.findAll();
    }

    //Metodo Update
    public MissoesModel atualizar(Long id, MissoesModel missao){
        if(missoesRepository.existsById(id)){
            missao.setId(id);
            return missoesRepository.save(missao);
        }
        return null;
    }

    //Metodo para Deletar
    public void deletar(Long id) {
        if (missoesRepository.existsById(id)) {
            missoesRepository.deleteById(id);
        }else{
            throw new CadastroNotFound("Cadastro nao encontrado");
        }
    }
}
