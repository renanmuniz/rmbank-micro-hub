package com.rmbank.microhub.v1.hexagono.processo.contrato;

import com.rmbank.microhub.v1.rest.dto.LoginForm;
import com.rmbank.microhub.v1.rest.dto.TokenDto;

public interface ProcessoAutenticacao {
    TokenDto autenticar(LoginForm form);
}
