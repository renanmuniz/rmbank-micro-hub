package com.rmbank.microhub.v1.hexagono.dominio;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @NotEmpty
    @Column(name = "nome")
    public String nome;

    @NotNull
    @NotEmpty
    @Column(name = "senha")
    public String senha;

    @NotNull
    @Column(name = "cadastro")
    public Long cadastro;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String senha, Long cadastro) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cadastro = cadastro;
        validar();
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, String senha, Long cadastro) {
        this.nome = nome;
        this.senha = senha;
        this.cadastro = cadastro;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getCadastro() {
        return cadastro;
    }

    public void setCadastro(Long cadastro) {
        this.cadastro = cadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) && Objects.equals(senha, usuario.senha) && Objects.equals(cadastro, usuario.cadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, senha, cadastro);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void validar() {
        Validador.validar(this);
    }
}
