package com.rmbank.microhub.v1.hexagono.porta.contrato;

import com.rmbank.microhub.v1.hexagono.exception.AutenticacaoException;
import com.rmbank.microhub.v1.rest.dto.LoginForm;
import com.rmbank.microhub.v1.rest.dto.TokenDto;

public interface PortaAutenticacao {

    TokenDto autenticar (LoginForm lofin) throws Exception;

}
