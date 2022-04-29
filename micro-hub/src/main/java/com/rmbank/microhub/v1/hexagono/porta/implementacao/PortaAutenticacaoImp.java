package com.rmbank.microhub.v1.hexagono.porta.implementacao;

import com.rmbank.microhub.v1.hexagono.porta.contrato.PortaAutenticacao;
import com.rmbank.microhub.v1.hexagono.processo.contrato.ProcessoAutenticacao;
import com.rmbank.microhub.v1.rest.dto.LoginForm;
import com.rmbank.microhub.v1.rest.dto.TokenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PortaAutenticacaoImp implements PortaAutenticacao {

    @Autowired
    ProcessoAutenticacao processoAutenticacao;

    @Override
    public TokenDto autenticar(LoginForm login) {
        log.info("Chamada rest para porta PortaAutenticacao");
        try {
            TokenDto token = processoAutenticacao.autenticar(login);
            return token;
        } catch (Exception e) {
            log.error("Erro na chamada do processo de autenticacao: " + e.getMessage());
        }
        return null;
    }
}
