package com.rmbank.microhub.v1.rest.contrato;

import com.rmbank.microhub.v1.rest.dto.LoginForm;
import com.rmbank.microhub.v1.rest.dto.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AutenticacaoRest {
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form);
}
