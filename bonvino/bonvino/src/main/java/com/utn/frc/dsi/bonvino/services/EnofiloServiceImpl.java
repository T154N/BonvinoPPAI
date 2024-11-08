package com.utn.frc.dsi.bonvino.services;

import com.utn.frc.dsi.bonvino.entities.Enofilo;
import com.utn.frc.dsi.bonvino.repositories.EnofiloRepository;
import com.utn.frc.dsi.bonvino.services.ServiceImpl;
import com.utn.frc.dsi.bonvino.services.interfaces.EnofiloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EnofiloServiceImpl extends ServiceImpl<Enofilo, Integer> implements EnofiloService {

    private final EnofiloRepository enofiloRepository;

    @Override
    public List<Enofilo> findAll(){
        return enofiloRepository.findAll();
    }

    @Override
    public Enofilo create(Enofilo entity) {
        enofiloRepository.save(entity);
        return entity;
    }

    @Override
    public Enofilo update(Integer id, Enofilo entity) {
        enofiloRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        enofiloRepository.deleteById(id);
    }

    @Override
    public Enofilo findById(Integer id) {
        return enofiloRepository.findById(id).orElse(null);
    }
}