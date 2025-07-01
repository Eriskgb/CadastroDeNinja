package dev.java10x.CadsatroDeNinja.Services;

import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import dev.java10x.CadsatroDeNinja.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //anotacao para identificar que toda logica de negocio sera executada pela camada services
public class NinjasServices {

    @Autowired // ira fornecer automaticamente um estancia de MissoesRepository
    private NinjaRepository ninjaRepository;

    //metodo para buscar por nome'
    public Optional<NinjaModel> buscarPorNome (String nome) {
        return ninjaRepository.findByNome(nome);
    }
    //Metodo para bucar por parte do nome
    public List<NinjaModel> buscarParteNome (String nome){
        return ninjaRepository.findByParteNome(nome);
    }
    //Metodo para buscar por idade
    public List<NinjaModel> buscaIdade(int idade){
        return ninjaRepository.findByIdade(idade);
    }
    //Metodo para Cria/Salvar um novo registro
    public NinjaModel salvarNinja(NinjaModel ninjamodel){
        return ninjaRepository.save(ninjamodel);
    }
    //Metodo para Deletar Ninja
    public void DeletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }
}
