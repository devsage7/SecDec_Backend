package com.gestiondeportiva.proyectoGestion.Mappers;

import com.gestiondeportiva.proyectoGestion.DTOs.AlumnoDTO;
import com.gestiondeportiva.proyectoGestion.DTOs.DisciplinaDTO;
import com.gestiondeportiva.proyectoGestion.DTOs.ProfesorDTO;
import com.gestiondeportiva.proyectoGestion.Dominio.*;

import java.sql.Date;
import java.util.List;

public class ProfesorMapper {

    private Integer id_p;
    private List<DisciplinaDTO> disciplinas;

    public static ProfesorDTO entityToDTO(Profesor p) {
        ProfesorDTO pDto = new ProfesorDTO();
        pDto.setNomyApe(p.getNomyApe());
        pDto.setDni(p.getDni());
        pDto.setDomicilio(p.getDomicilio());
        pDto.setLocalidad(p.getLocalidad());
        pDto.setProvincia(p.getProvincia());
        pDto.setTel(p.getTel());
        pDto.setFecNac(p.getFecNac());
        pDto.setSexo(p.getSexo());
        pDto.setObservaciones(p.getObservaciones());
        pDto.setFecIng(p.getFecIng());
        for (Disciplina d : p.getDisciplinas()) {
            pDto.getDisciplinas().add(d.getId_d());
        }
        pDto.setId_p(p.getId_p());
        return pDto;
    }

    public static Profesor DTOToEntity(ProfesorDTO pDto) {
        Profesor p = new Profesor();
        p.setNomyApe(pDto.getNomyApe());
        p.setDni(pDto.getDni());
        p.setDomicilio(pDto.getDomicilio());
        p.setLocalidad(pDto.getLocalidad());
        p.setProvincia(pDto.getProvincia());
        p.setTel(pDto.getTel());
        p.setFecNac(pDto.getFecNac());
        p.setSexo(pDto.getSexo());
        p.setObservaciones(pDto.getObservaciones());
        p.setFecIng(pDto.getFecIng());

        /*
        for (Integer id_d : pDto.getDisciplinas()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setId_d(id_d);
            p.getDisciplinas().add(disciplina);
        }
         */

        p.setId_p(pDto.getId_p());
        return p;
    }

}