package verificacao.estoque.validador;

import verificacao.estoque.dto.MensagemEstruturada;
import verificacao.estoque.dto.Produto;
import verificacao.estoque.dto.Transacao;

import java.util.Optional;

public interface Validador {


    void validar(Produto produto, Transacao transacao, MensagemEstruturada mensagemEstruturada);
}
