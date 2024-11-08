package com.utn.frc.dsi.bonvino.controllers;

import com.utn.frc.dsi.bonvino.entities.Bodega;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BodegaResponse {
    private String message;
    private List<Bodega> bodegas;
}
