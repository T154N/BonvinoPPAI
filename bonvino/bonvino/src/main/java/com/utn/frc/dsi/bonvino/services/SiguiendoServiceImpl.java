package com.utn.frc.dsi.bonvino.services;

import com.utn.frc.dsi.bonvino.entities.Siguiendo;
import com.utn.frc.dsi.bonvino.repositories.SiguiendoRepository;
import com.utn.frc.dsi.bonvino.services.interfaces.SiguiendoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiguiendoServiceImpl extends ServiceImpl<Siguiendo, Integer> implements SiguiendoService {

    private final SiguiendoRepository siguiendoRepository;

    @Override
    public List<Siguiendo> findAll(){
        return siguiendoRepository.findAll();
    }

    @Override
    public Siguiendo create(Siguiendo entity){
        siguiendoRepository.save(entity);
        return entity;
    }

    @Override
    public Siguiendo update(Integer id, Siguiendo entity){
        siguiendoRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        Siguiendo entity = findById(id);
        siguiendoRepository.delete(entity);
    }

    @Override
    public Siguiendo findById(Integer id){
        return siguiendoRepository.findById(id).orElseThrow();
    }
}
