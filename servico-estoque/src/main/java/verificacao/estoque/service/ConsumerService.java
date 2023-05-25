package verificacao.estoque.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import verificacao.estoque.dto.MensagemEstruturada;
import verificacao.estoque.dto.Produto;
import verificacao.estoque.dto.Transacao;
import verificacao.estoque.repository.ProdutoRepository;
import verificacao.estoque.validador.ValidadorMensagemImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@Component
@AllArgsConstructor
public class ConsumerService {

    private ProducerService producerService;
    private ProdutoRepository produtoRepository;
    @Autowired
    private ValidadorMensagemImpl validadorMensagem;


    @KafkaListener(topics = "estoque-api")
    public void listen(String message){

        try {
            System.out.println(message);
            processo(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


    private void processo(String message) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Transacao transacao =  objectMapper.readValue(message, Transacao.class);


        Produto produto = produtoRepository.findById(transacao.getProduto().getId()).get();

        MensagemEstruturada mensagemEstruturada = new MensagemEstruturada();
        mensagemEstruturada.setDataTransacao(Timestamp.valueOf(LocalDateTime.now()));
        mensagemEstruturada.setProduto(transacao.getProduto());
        mensagemEstruturada.setNome(transacao.getNome());
        mensagemEstruturada.setEmail(transacao.getEmail());

        validadorEstoque(transacao, produto, mensagemEstruturada);

        atualizarEstoque(transacao, produto);

        producerService.enviarParaTopico(mensagemEstruturada);


    }


        private void atualizarEstoque(Transacao transacao, Produto produto) {
            Integer totalAtualizado = produto.getQuantidade() - transacao.getProduto().getQuantidade();
            System.out.println(totalAtualizado);

            if (!(totalAtualizado<0)){

                produto.setQuantidade(totalAtualizado);

                produtoRepository.save(produto);

            }


        }

        private void validadorEstoque(Transacao transacao, Produto produto, MensagemEstruturada mensagemEstruturada){

            validadorMensagem.validar(produto, transacao, mensagemEstruturada);
        }

}
