package dev.java10x.CadsatroDeNinja.Ninjas;
import dev.java10x.CadsatroDeNinja.Exceptions.CadastroNotFound;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjasDTO> listarTodos(){
        List<NinjaModel> ninjas = ninjaRepository.findAll(); //Armazendo o resultado da consulta de todos o cadastro na List
        return ninjas.stream() //utilizando Streams para mapear o conteudo da Lista
                .map(ninjasMapper::map)
                .collect(Collectors.toList()); //Transformando o conteudo de uma lista Organizada e pocessada.
    }

    //Metodo para listsar os ninjas por ID
    public NinjasDTO listarId (Long id){
       Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id); //Verificando a existencia do ID passado no paramettro e armazenando na varial
       return ninjaModel.map(ninjasMapper::map).orElse(null); // retornando o valor utilizando streams
    }

    //Meotod para criar novo ninja
    public NinjasDTO criarNinja(NinjasDTO ninjaDTO){
        NinjaModel ninja = ninjasMapper.map(ninjaDTO); // Variavel que armazenara os dados passados pelo usuario
        ninja = ninjaRepository.save(ninja); //Salvando os dados no repositorio
        return ninjasMapper.map(ninja); //retornando os dados para o usuario
    }

    //Metodo para deletar registro
    public void deletarId(Long id){
        if(ninjaRepository.existsById(id)){//Verificando a existencia do ID no cadastro
            ninjaRepository.deleteById(id);//Deletando o ID
        }else{
            throw new CadastroNotFound("Ninha nao encontrado");
        }
    }

    //Metodo para ataualizar um cadastro ja existesnte
    public NinjasDTO atualizarId(Long id, NinjasDTO ninjasDTO){
       Optional<NinjaModel> ninjaExiste = ninjaRepository.findById(id); //Verificando a existencia do ID
       if(ninjaExiste.isPresent()){ //Se o ID existir, fazer a acao abaixo
           NinjaModel ninjaUpdate = ninjasMapper.map(ninjasDTO); // guardando os dados novo passados pelo usuario
           ninjaUpdate.setId(id); //setando esse novos dados ao ID que foi para sobrecrever\
           NinjaModel ninjaSave = ninjaRepository.save(ninjaUpdate); //Salvando os dados novos
           return ninjasMapper.map(ninjaSave);// retornando o novo cadastro atualizado
       }
       return null;
    }

}
