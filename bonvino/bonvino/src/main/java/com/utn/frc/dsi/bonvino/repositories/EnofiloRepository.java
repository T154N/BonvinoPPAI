package com.utn.frc.dsi.bonvino.repositories;

import com.utn.frc.dsi.bonvino.entities.Enofilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnofiloRepository extends JpaRepository<Enofilo, Integer> {
}
