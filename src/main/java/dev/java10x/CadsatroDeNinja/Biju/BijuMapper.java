package dev.java10x.CadsatroDeNinja.Biju;

import org.springframework.stereotype.Component;

@Component
public class BijuMapper {

    public BijuDTO map(BijuModel bijuModel){

        BijuDTO  bijuDTO = new BijuDTO();
        bijuDTO.setId(bijuModel.getId());
        bijuDTO.setNome(bijuModel.getNome());
        bijuDTO.setQtdCaldas(bijuModel.getQtdCaldas());
        bijuDTO.setJinchurikis(bijuModel.getJinchurikis());
        return bijuDTO;
    }

    public BijuModel map(BijuDTO bijuDTO){

        BijuModel bijuModel = new BijuModel();
        bijuModel.setId(bijuDTO.getId());
        bijuModel.setNome(bijuDTO.getNome());
        bijuModel.setQtdCaldas(bijuDTO.getQtdCaldas());
        bijuModel.setJinchurikis(bijuDTO.getJinchurikis());
        return bijuModel;

    }
}
