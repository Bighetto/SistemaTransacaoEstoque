package verificacao.estoque.dto;

import lombok.Data;

@Data
public class Transacao {

    public String email;
    public String nome;
    public Produto produto;
}
