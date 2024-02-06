package com.gestiondeportiva.proyectoGestion.DTOs;

import com.gestiondeportiva.proyectoGestion.Dominio.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class CuotaMensualDTO {
    private ClaveCuota claveCuota;
    private float importeCuota;
    private Integer alumno;
    private Integer disciplina;
    private Optional<PagoDeCuotaDTO> pdc;
}