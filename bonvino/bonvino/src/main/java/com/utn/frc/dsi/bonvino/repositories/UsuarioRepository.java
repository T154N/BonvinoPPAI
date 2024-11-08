package com.utn.frc.dsi.bonvino.repositories;

import com.utn.frc.dsi.bonvino.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
