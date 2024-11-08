package com.utn.frc.dsi.bonvino.services;

import com.utn.frc.dsi.bonvino.entities.Bodega;
import com.utn.frc.dsi.bonvino.repositories.BodegaRepository;
import com.utn.frc.dsi.bonvino.repositories.VinoRepository;
import com.utn.frc.dsi.bonvino.services.interfaces.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaServiceImpl extends ServiceImpl<Bodega, Integer> implements BodegaService {

    private final BodegaRepository bodegaRepository;
    private final VinoRepository vinoRepository;

    @Override
    public List<Bodega> findAll(){
        return bodegaRepository.findAll();
    }

    @Override
    public Bodega create(Bodega entity){
        bodegaRepository.save(entity);
        return entity;
    }

    @Override
    public Bodega update(Integer id,Bodega entity){
        bodegaRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        Bodega entity = findById(id);
        bodegaRepository.delete(entity);
    }

    @Override
    public Bodega findById(Integer id){
        return bodegaRepository.findById(id).orElseThrow();
    }


}
