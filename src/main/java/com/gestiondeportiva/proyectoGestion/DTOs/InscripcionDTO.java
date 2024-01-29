package com.gestiondeportiva.proyectoGestion.DTOs;

import com.gestiondeportiva.proyectoGestion.Dominio.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class InscripcionDTO {
    private Integer icod;
    private Date fecInsc;
    private Date fecVenc;
    private float importeUnico;
    private TipoInscripcion tipoInscr;
    private Integer alumno;
    private String disciplinaNombre;
    private Integer disciplina;
    private String usuarioNombre;
    private Integer usuario;
    private List<CuotaMensualDTO> cuotasMensuales = new ArrayList<>();
}
