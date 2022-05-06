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
    public TokenDto autenticar(LoginForm login) throws Exception {
        log.info("Chamada porta PortaAutenticacao. Usuário: " + login.getUsuario());
        return processoAutenticacao.autenticar(login);
    }
}
