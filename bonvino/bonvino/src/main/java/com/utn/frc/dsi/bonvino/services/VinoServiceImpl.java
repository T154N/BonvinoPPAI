package com.utn.frc.dsi.bonvino.services;

import com.utn.frc.dsi.bonvino.entities.Vino;
import com.utn.frc.dsi.bonvino.repositories.VinoRepository;
import com.utn.frc.dsi.bonvino.services.interfaces.VinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VinoServiceImpl extends ServiceImpl<Vino, Integer> implements VinoService {


    private final VinoRepository vinoRepository;

    @Override
    public List<Vino> findAll() {
        // Aquí debes llamar a la instancia del repositorio, no de forma estática
        return vinoRepository.findAll();
    }

    @Override
    public Vino create(Vino entity) {
        vinoRepository.save(entity);
        return entity;
    }

    @Override
    public Vino update(Integer id, Vino entity) {
        vinoRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        Vino entity = findById(id);
        vinoRepository.delete(entity);
    }

    @Override
    public Vino findById(Integer id) {
        return vinoRepository.findById(id).orElseThrow();
    }


}
