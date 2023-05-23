package transacao.estoque.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import transacao.estoque.api.dto.TransacaoDTO;

@Service
public class TransacaoService {

    String TOPICO_KAFKA = "estoque-api";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public TransacaoService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void enviarParaTopico(TransacaoDTO transacaoDTO) {

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String message = objectMapper.writeValueAsString(transacaoDTO);
            sendMessage(TOPICO_KAFKA, message);
            System.out.println(message);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }


    }
}
