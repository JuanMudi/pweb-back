package com.parcial.web.parcial.models.celular;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "celular")
@SQLDelete(sql = "UPDATE celular SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Celular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "La marca es obligatorio")
    @Size(min = 1, max = 100, message = "La marca es muy larga")
    private String marca;

    @NotBlank(message = "El serial es obligatorio")
    @Size(min = 1, max = 100, message = "El serial es muy largo")
    @Column(unique = true)
    private String serial;

    @NotBlank(message = "La fecha de compra es obligatoria")
    @Temporal(TemporalType.DATE)
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

    private boolean deleted = false;
}
