package servico.email.mensagens;

import org.springframework.stereotype.Component;
import servico.email.models.MensagemEstruturada;

@Component
public class EstruturarMensagemSucesso implements EstruturarMensagem{


    @Override
    public String estruturarMensagem(MensagemEstruturada mensagemEstruturada) {

        String mensagem = "Ola, ".concat(mensagemEstruturada.getNome()).concat(". Sua transacao foi completa com sucesso! ")
                .concat("Parabens por adquirir o produto: ".concat(mensagemEstruturada.getProduto().getNome())).concat(" !!");

        return mensagem;

    }
}
