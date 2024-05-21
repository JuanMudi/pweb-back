package com.parcial.web.parcial.models.celular.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SimpleCelDTO {

    private UUID id;

    @NotBlank(message = "La marca es obligatorio")
    @Size(min = 1, max = 100, message = "La marca es muy larga")
    private String marca;

    @NotBlank(message = "El serial es obligatorio")
    @Size(min = 1, max = 100, message = "El serial es muy largo")
    private String serial;

    @NotBlank(message = "La fecha de compra es obligatoria")
    private Date fechaCompra;

    @NotBlank(message = "El año de lanzamiento es obligatorio")
    @Size(min = 4, max = 4, message = "El año de lanzamiento debe ser de 4 dígitos")
    private String añoLanzamiento;

    @NotBlank(message = "El precio es obligatorio")
    private Double precio;

    @NotBlank(message = "El sistema operativo es obligatorio")
    private String sistemaOperativo;

    @NotBlank(message = "La gama es obligatoria")
    private String gama;
}
