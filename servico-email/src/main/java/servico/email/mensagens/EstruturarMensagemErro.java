package servico.email.mensagens;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import servico.email.models.MensagemEstruturada;

@Component
@Primary
public class EstruturarMensagemErro implements EstruturarMensagem{
    @Override
    public String estruturarMensagem(MensagemEstruturada mensagemEstruturada) {

        String mensagem = "Ola, ".concat(mensagemEstruturada.getNome()).concat(". Infelizmente nao conseguimos completar sua transacao. ")
                .concat("O produto: ".concat(mensagemEstruturada.getProduto().getNome())).concat(" nao esta mais disponivel.");

        return mensagem;

    }
}
