package verificacao.estoque.validador;

import org.springframework.stereotype.Component;
import verificacao.estoque.dto.MensagemEstruturada;
import verificacao.estoque.dto.Produto;
import verificacao.estoque.dto.Transacao;

import java.util.Optional;

@Component
public class ValidadorMensagemImpl implements Validador{
    @Override
    public void validar(Produto produto, Transacao transacao, MensagemEstruturada mensagemEstruturada) {



        if (produto.getQuantidade()>= transacao.getProduto().getQuantidade()){

            mensagemEstruturada.setValid(true);


        }else {
            mensagemEstruturada.setValid(false);
        }

    }
}
