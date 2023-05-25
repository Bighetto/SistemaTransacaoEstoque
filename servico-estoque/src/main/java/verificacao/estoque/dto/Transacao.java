package verificacao.estoque.dto;

import lombok.Data;

@Data
public class Transacao {

    private String email;
    private String nome;
    private Produto produto;
}
