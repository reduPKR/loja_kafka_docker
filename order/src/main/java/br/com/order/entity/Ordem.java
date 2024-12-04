package br.com.order.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ordem")
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String numeroOrdem;
    @NotNull
    private boolean concluido;

    public Ordem() {
    }

    public Ordem(String numeroOrdem, boolean concluido) {
        this.numeroOrdem = numeroOrdem;
        this.concluido = concluido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(String numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
