package dev.java10x.CadsatroDeNinja.Biju;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BijuDTO {
        private Long id;
        private String nome;
        private int qtdCaldas;
        private List<NinjaModel> jinchurikis;
}
