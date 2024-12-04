package br.com.payment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotEmpty
    @NotBlank
    private String numeroOrdem;
    @NotNull
    @NotEmpty
    @NotBlank
    private String numeroPagamento;
    @NotNull
    private boolean concluido;

    public Pagamento() {
    }

    public Pagamento(String numeroOrdem, String numeroPagamento, boolean concluido) {
        this.numeroOrdem = numeroOrdem;
        this.numeroPagamento = numeroPagamento;
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

    public String getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(String numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
