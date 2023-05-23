package verificacao.estoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import verificacao.estoque.dto.Transacao;

@Component
public class ApiTopicConsumer {

    @KafkaListener(topics = "estoque-api")
    public void listen(String message) {

//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            Transacao transacao = objectMapper.readValue(message, Transacao.class);
//
//            System.out.println(transacao);
//
//
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }


        System.out.println("Received message: " + message);
    }
}
