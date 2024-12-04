package br.com.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record OrdemRequest(@NotNull @NotEmpty @NotBlank String numeroOrdem) {
}
