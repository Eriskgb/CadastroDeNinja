package dev.java10x.CadsatroDeNinja.Aldeia;
import org.springframework.stereotype.Component;

@Component
public class AldeiaMapper {

    public AldeiaDTO map(AldeiaModel aldeiaModel){

        AldeiaDTO aldeiaDTO = new AldeiaDTO();
        aldeiaDTO.setId(aldeiaDTO.getId());
        aldeiaDTO.setNome(aldeiaDTO.getNome());
        aldeiaDTO.setPais(aldeiaDTO.getPais());
        aldeiaDTO.setNinja(aldeiaModel.getNinja());

        return map(aldeiaModel);
    }

    public AldeiaModel map(AldeiaDTO aldeiaDTO){

        AldeiaModel aldeiaModel = new AldeiaModel();
        aldeiaModel.setId(aldeiaDTO.getId());
        aldeiaModel.setNome(aldeiaDTO.getNome());
        aldeiaModel.setPais(aldeiaDTO.getPais());
        aldeiaModel.setNinja(aldeiaDTO.getNinja());
        return map(aldeiaDTO);
    }

}
