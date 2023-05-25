package verificacao.estoque.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import verificacao.estoque.dto.MensagemEstruturada;

@Service
public class ProducerService {

    String TOPICO_KAFKA = "transacao-registro";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void enviarParaTopico(MensagemEstruturada mensagemEstruturada) {

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String message = objectMapper.writeValueAsString(mensagemEstruturada);
            sendMessage(TOPICO_KAFKA, message);
            System.out.println(message);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }


    }
}
