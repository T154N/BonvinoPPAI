package com.utn.frc.dsi.bonvino.repositories;

import com.utn.frc.dsi.bonvino.entities.Vino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinoRepository extends JpaRepository<Vino, Integer> {
}

