package dev.java10x.CadsatroDeNinja.Aldeia;
import dev.java10x.CadsatroDeNinja.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AldeiaDTO {
    private Long id;
    private String nome;
    private String pais;
    private List<NinjaModel> ninja;
}
