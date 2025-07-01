package dev.java10x.CadsatroDeNinja.Services;
import dev.java10x.CadsatroDeNinja.Missoes.MissoesModel;
import dev.java10x.CadsatroDeNinja.Repository.MissoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //anotacao para identificar que toda logica de negocio sera executada pela camada services
public class MissoesServices {

    @Autowired // ira fornecer automaticamente um estancia de MissoesRepository
    private MissoesRepository missoesRepository;

    //Metodo para buscar por nome
    public Optional<MissoesModel> buscarPorNome (String nome){
        return missoesRepository.findByNome(nome);
    }
    //Metodo para buscar por parte do nome
    public List<MissoesModel> buscarParteNome(String nome){
        return missoesRepository.findByNomeContaining(nome);
    }
    //Metodo para buscar por dificuldade
    public List<MissoesModel> buscarDificuldade(String dificuldade){
        return missoesRepository.findByDificuldade(dificuldade);
    }
    //Metodo para salvar regitro de Missoes
    public MissoesModel SalvarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }
    //Metodo para deletar um registo
    public void deletarMissao(Integer id){
        missoesRepository.deleteById(id);
    }
    //Metodo para atualizar um registro
    public MissoesModel atualizar(Integer id, MissoesModel dadosAtualizados){
        //validacao para garantir o retorno de um registro antes de atualizacao
        MissoesModel missaoExistente = missoesRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Missão não encontrada com ID: " + id));

        //setando o novo registro para os dados retornado na variavel missaoExistente
        missaoExistente.setNome(dadosAtualizados.getNome());
        // Salvar e retornar a missão atualizada
        return missoesRepository.save(missaoExistente);
    }

}
