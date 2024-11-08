package com.utn.frc.dsi.bonvino.repositories;

import com.utn.frc.dsi.bonvino.entities.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

}
