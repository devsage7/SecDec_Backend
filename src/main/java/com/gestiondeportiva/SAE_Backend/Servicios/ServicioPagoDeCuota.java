package com.gestiondeportiva.proyectoGestion.Servicios;

import com.gestiondeportiva.proyectoGestion.DTOs.*;
import com.gestiondeportiva.proyectoGestion.Dominio.*;
import com.gestiondeportiva.proyectoGestion.Mappers.*;
import com.gestiondeportiva.proyectoGestion.Persistencia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPagoDeCuota {

    private final IPagoDeCuotaRepositorio pagoDeCuotaRepositorio;
    private final IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    public ServicioPagoDeCuota(IPagoDeCuotaRepositorio pagoDeCuotaRepositorio,IUsuarioRepositorio usuarioRepositorio) {
        this.pagoDeCuotaRepositorio = pagoDeCuotaRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public PagoDeCuotaDTO createOrUpdate(PagoDeCuotaDTO pdc){
        PagoDeCuota nuevoPago = PagoDeCuotaMapper.DTOToEntity(pdc);

        Optional<Usuario> u = usuarioRepositorio.findByUsername(pdc.getUsuarioNombre());
        if (u.isPresent()) {
            nuevoPago.setUsuario(u.get());
        }
        return PagoDeCuotaMapper.entityToDTO(pagoDeCuotaRepositorio.save(nuevoPago));
    }

    public List<PagoDeCuotaDTO> selectAll() {
        List<PagoDeCuotaDTO> lpDto = new ArrayList<>();
        for (PagoDeCuota pdc: pagoDeCuotaRepositorio.findAll()) {
            lpDto.add(PagoDeCuotaMapper.entityToDTO(pdc));
        }
        return lpDto;
    }

    public PagoDeCuotaDTO selectById(Integer id_pdc) {

        return PagoDeCuotaMapper.entityToDTO(pagoDeCuotaRepositorio.findById(id_pdc).orElse(null));
    }

    public void delete(Integer id_pdc) {
        pagoDeCuotaRepositorio.deleteById(id_pdc);
    }

}