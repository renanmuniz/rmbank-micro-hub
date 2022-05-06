package com.rmbank.microhub.v1.rest.exception.advice;

import com.rmbank.microhub.v1.hexagono.exception.NegocioException;
import com.rmbank.microhub.v1.rest.dto.ErroDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ControllerAdvice(basePackages = "com.rmbank.microhub.v1.rest.implementacao")
public class ClienteRestAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NegocioException.class)
    public ErroDto handleAutenticacaoException(NegocioException negocioException) {
        ErroDto erroDto = new ErroDto();
        erroDto.setStatus(HttpStatus.BAD_REQUEST.value());
        erroDto.setMessage(negocioException.getMessage());
        erroDto.setTimestamp(new Date());
        return erroDto;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErroDto handleException(NegocioException negocioException) {
        ErroDto erroDto = new ErroDto();
        erroDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        erroDto.setMessage("Erro interno do servidor. Entre em contato com a equipe de suporte.");
        erroDto.setTimestamp(new Date());
        return erroDto;
    }
}
