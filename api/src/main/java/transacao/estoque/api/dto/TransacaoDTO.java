package transacao.estoque.api.dto;

import lombok.Data;

@Data
public class TransacaoDTO {

    public String email;
    public String nome;
    public Produto produto;
}
