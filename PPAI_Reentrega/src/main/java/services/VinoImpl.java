package services;

import models.Vino;
import models.VinoId;
import org.springframework.stereotype.Service;
import repositories.VinoRepository;
import services.interfaces.VinoService;

import java.util.List;
/*
@Service
public class VinoImpl extends ServiceImpl<Vino, VinoId> implements VinoService {

    private final VinoRepository vinoRepository;

    @Override
    public Vino create(Vino entity){
        vinoRepository.save(entity);
        return entity;
    }

    @Override
    public Vino update(VinoId vinoId, Vino entity){
        entity.setAniada(vinoId.getAniada());
        entity.setNombre(vinoId.getNombreVino());
        vinoRepository.save(entity);
        return entity;
    }

    @Override
    public void delete (VinoId vinoId){
        Vino entity = findById(vinoId);
        vinoRepository.delete(entity);
    }

    @Override
    public Vino findById(VinoId vinoId){
        return vinoRepository.findById(vinoId).orElseThrow();
    }

    @Override
    public List<Vino> findAll() {
        return vinoRepository.findAll();
    }
}
*/