package com.utn.frc.dsi.bonvino.repositories;


import com.utn.frc.dsi.bonvino.entities.Siguiendo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiguiendoRepository extends JpaRepository<Siguiendo, Integer> {

}
