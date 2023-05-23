package transacao.estoque.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import transacao.estoque.api.dto.TransacaoDTO;
import transacao.estoque.api.service.TransacaoService;

@RestController
@AllArgsConstructor
public class TransacaoController {

    @Autowired
    private final TransacaoService transacaoService;

    @PostMapping("/solicitarTransacao")
    public void solicitarTransacao(@RequestBody TransacaoDTO transacaoDTO){

        transacaoService.enviarParaTopico(transacaoDTO);




    }
}
