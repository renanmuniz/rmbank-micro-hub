package com.rmbank.microhub.v1.rest.implementacao;

import com.rmbank.microhub.v1.hexagono.porta.contrato.PortaAutenticacao;
import com.rmbank.microhub.v1.rest.contrato.AutenticacaoRest;
import com.rmbank.microhub.v1.rest.dto.LoginForm;
import com.rmbank.microhub.v1.rest.dto.TokenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AutenticacaoRestImp implements AutenticacaoRest {

    @Autowired
    private PortaAutenticacao porta;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
        log.info("Chamada POST em /auth com o usuário: " + form.getUsuario());
        TokenDto token = porta.autenticar(form);
        if(token != null){
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
