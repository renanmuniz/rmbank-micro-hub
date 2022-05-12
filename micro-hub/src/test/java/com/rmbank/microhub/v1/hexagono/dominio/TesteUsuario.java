package com.rmbank.microhub.v1.hexagono.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TesteUsuario {

    static Usuario fabricarValido() {
        return new Usuario(1L, "Renan Muniz Merlo", "1234", 1L);
    }

    @Test
    void testaIdNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.id = null;
            usuario.validar();
            Assertions.fail("Deveria reclamar id nulo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testaNomeNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.nome = null;
            usuario.validar();
            Assertions.fail("Deveria reclamar nome nulo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testaNomeVazio() {
        try {
            Usuario usuario = fabricarValido();
            usuario.nome = "";
            usuario.validar();
            Assertions.fail("Deveria reclamar nome vazio");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testaSenhaNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.senha = null;
            usuario.validar();
            Assertions.fail("Deveria reclamar senha nulo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testaSenhaVazio() {
        try {
            Usuario usuario = fabricarValido();
            usuario.senha = "";
            usuario.validar();
            Assertions.fail("Deveria reclamar senha vazio");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testaCadastroNulo() {
        try {
            Usuario usuario = fabricarValido();
            usuario.cadastro = null;
            usuario.validar();
            Assertions.fail("Deveria reclamar cadastro nulo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testaUsuarioValido() {
        try {
            Usuario usuario = fabricarValido();
        } catch (Exception e) {
            Assertions.fail("Nao deveria reclamar de usuario valido - " + e.getMessage());
        }
    }

}
