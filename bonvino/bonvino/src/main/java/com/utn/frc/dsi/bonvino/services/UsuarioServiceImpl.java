package com.utn.frc.dsi.bonvino.services;


import com.utn.frc.dsi.bonvino.entities.Usuario;
import com.utn.frc.dsi.bonvino.repositories.UsuarioRepository;
import com.utn.frc.dsi.bonvino.services.interfaces.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends ServiceImpl<Usuario, Integer> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario create(Usuario entity){
        usuarioRepository.save(entity);
        return entity;
    }

    @Override
    public Usuario update(Integer id, Usuario entity){
        usuarioRepository.save(entity);
        return entity;
    }

    @Override
    public void delete(Integer id){
        Usuario entity = findById(id);
        usuarioRepository.delete(entity);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

}
