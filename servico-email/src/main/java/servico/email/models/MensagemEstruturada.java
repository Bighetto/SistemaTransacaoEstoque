package servico.email.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemEstruturada {

    private String email;
    private String nome;
    private Timestamp dataTransacao;
    private boolean isValid;
    private Produto produto;
}
