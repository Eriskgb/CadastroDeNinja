package dev.java10x.CadsatroDeNinja.Ninjas;
import org.springframework.stereotype.Component;

@Component // Mapper e uma componente.
public class NinjasMapper {

    public NinjaModel map(NinjasDTO ninjasDTO){

        //Estanciando a Entidade NinjaModel, o mapper server para explicar para o Spring que o atributo do DTO equivale ao atributo da entidade
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjasDTO.getId());
        ninjaModel.setNome(ninjasDTO.getNome());
        ninjaModel.setEmail(ninjasDTO.getEmail());
        ninjaModel.setIdade(ninjasDTO.getIdade());
        ninjaModel.setImgUrl(ninjasDTO.getImgUrl());
        ninjaModel.setRank(ninjasDTO.getRank());
        ninjaModel.setMissao(ninjasDTO.getMissao());
        ninjaModel.setJinchuriki((ninjasDTO.getJinchuriki()));
        ninjaModel.setAldeia(ninjasDTO.getAldeia());
        ninjaModel.setDoujutsu(ninjasDTO.getDoujutsu());

        //retorando a entidade NinjaModel
        return ninjaModel;
    }

    //Processo inverso, mapear o ninjaDTO para o NinjaModel
    public NinjasDTO map(NinjaModel ninjaModel){

        NinjasDTO ninjasDTO = new NinjasDTO();

        ninjasDTO.setId(ninjaModel.getId());
        ninjasDTO.setNome(ninjaModel.getNome());
        ninjasDTO.setIdade(ninjaModel.getIdade());
        ninjasDTO.setEmail(ninjaModel.getEmail());
        ninjasDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjasDTO.setRank(ninjaModel.getRank());
        ninjasDTO.setMissao(ninjaModel.getMissao());
        ninjasDTO.setJinchuriki(ninjaModel.getJinchuriki());
        ninjasDTO.setAldeia(ninjaModel.getAldeia());
        ninjasDTO.setDoujutsu(ninjaModel.getDoujutsu());
        return ninjasDTO;
    }




}
