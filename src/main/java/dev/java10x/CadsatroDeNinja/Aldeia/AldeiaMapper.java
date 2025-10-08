package dev.java10x.CadsatroDeNinja.Aldeia;
import org.springframework.stereotype.Component;

@Component
public class AldeiaMapper {

    public AldeiaDTO map(AldeiaModel aldeiaModel){

        AldeiaDTO aldeiaDTO = new AldeiaDTO();

        aldeiaDTO.setId(aldeiaModel.getId());
        aldeiaDTO.setNome(aldeiaModel.getNome());
        aldeiaDTO.setPais(aldeiaModel.getPais());
        aldeiaDTO.setNinja(aldeiaModel.getNinja());
        return aldeiaDTO;
    }

    public AldeiaModel map(AldeiaDTO aldeiaDTO){

        AldeiaModel aldeiaModel = new AldeiaModel();
        aldeiaModel.setId(aldeiaDTO.getId());
        aldeiaModel.setNome(aldeiaDTO.getNome());
        aldeiaModel.setPais(aldeiaDTO.getPais());
        aldeiaModel.setNinja(aldeiaDTO.getNinja());

        return aldeiaModel;
    }

}
