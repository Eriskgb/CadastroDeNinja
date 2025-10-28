package dev.java10x.CadsatroDeNinja.Doujutsu;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoujutsuDTO {
    private Long id;
    private String nome;
    private List<NinjaModel> ninja;
}
