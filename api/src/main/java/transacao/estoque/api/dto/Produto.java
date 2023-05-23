package transacao.estoque.api.dto;

import lombok.Data;

@Data
public class Produto {

    private String id;
    private String nome;
    private String quantidade;
}
