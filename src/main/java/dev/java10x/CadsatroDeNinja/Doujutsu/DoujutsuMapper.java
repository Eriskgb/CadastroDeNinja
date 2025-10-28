package dev.java10x.CadsatroDeNinja.Doujutsu;

import org.springframework.stereotype.Component;

@Component
public class DoujutsuMapper {

    public DoujutsuModel map(DoujutsuDTO doujutsuDTO) {
        DoujutsuModel doujutsuModel = new DoujutsuModel();
        doujutsuModel.setId(doujutsuDTO.getId());
        doujutsuModel.setNome(doujutsuDTO.getNome());
        doujutsuModel.setNinja(doujutsuDTO.getNinja());
        return doujutsuModel;
    }
    public DoujutsuDTO map(DoujutsuModel doujutsuModel){
        DoujutsuDTO doujutsuDTO = new DoujutsuDTO();

        doujutsuDTO.setId(doujutsuModel.getId());
        doujutsuDTO.setNome(doujutsuModel.getNome());
        doujutsuDTO.setNinja(doujutsuModel.getNinja());
        return doujutsuDTO;
    }
}
