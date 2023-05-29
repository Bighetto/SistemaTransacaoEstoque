package servico.email.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import servico.email.emailsConfig.EmailService;
import servico.email.mensagens.EstruturarMensagem;
import servico.email.mensagens.EstruturarMensagemErro;
import servico.email.mensagens.EstruturarMensagemSucesso;
import servico.email.models.MensagemEstruturada;

@Service
@Component
@AllArgsConstructor
public class ConsumerService {

    private EmailService emailService;
    @Autowired
    private EstruturarMensagem estruturarMensagem;

    @KafkaListener(topics = "transacao-registro")
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

        MensagemEstruturada mensagemEstruturada =  objectMapper.readValue(message, MensagemEstruturada.class);

        String mensagem = processoEstruturaEmail(mensagemEstruturada);

        String titulo = "Teste Email";

        emailService.sendEmail(mensagemEstruturada.getEmail(),titulo, mensagem);



    }

    private String processoEstruturaEmail(MensagemEstruturada mensagemEstruturada) {



        if (mensagemEstruturada.isValid()){

            estruturarMensagem = new EstruturarMensagemSucesso();


        }else if (!mensagemEstruturada.isValid()){
             estruturarMensagem = new EstruturarMensagemErro();
        }

        String mensagem = estruturarMensagem.estruturarMensagem(mensagemEstruturada);

        return mensagem;


    }


}
