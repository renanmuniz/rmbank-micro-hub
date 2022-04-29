package com.rmbank.microhub.v1.hexagono.processo.implementacao;

import com.rmbank.microhub.v1.config.security.TokenService;
import com.rmbank.microhub.v1.hexagono.processo.contrato.ProcessoAutenticacao;
import com.rmbank.microhub.v1.rest.dto.LoginForm;
import com.rmbank.microhub.v1.rest.dto.TokenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessoAutenticacaoImp implements ProcessoAutenticacao {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public TokenDto autenticar(LoginForm form) {
        log.info("Chamado o ProcessoAutenticacao.autenticar()");
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            log.info("Usuário: " + form.getUsuario() + " autenticado.");
            return new TokenDto(token, "Bearer");
        } catch (AuthenticationException e) {
            log.error("Erro na autenticacao do usuario: " + form.getUsuario() + " - " + e.getMessage());
            return null;
        }
    }

}
