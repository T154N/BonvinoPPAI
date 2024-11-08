package com.utn.frc.dsi.bonvino.controllers;

import com.utn.frc.dsi.bonvino.entities.Bodega;
import com.utn.frc.dsi.bonvino.services.BodegaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vinos")
@RequiredArgsConstructor
public class ControllerActualizarVinos {

    private final BodegaServiceImpl bodegaService;

    @GetMapping("/actualizarVinos")
    public BodegaResponse buscarBodegasParaActualizar() {

        LocalDate fechaActual = LocalDate.now();

        List<Bodega> bodegasBdd = bodegaService.findAll();
        List<Bodega> bodegasDisponiblesParaActualizar = new ArrayList<>();

        for (Bodega bodegaBdd : bodegasBdd) {
            if (bodegaBdd.disponibleActualizar(fechaActual)) {
                bodegasDisponiblesParaActualizar.add(bodegaBdd);
            }
        }

        // Creamos la respuesta con un mensaje y la lista de bodegas
        return new BodegaResponse("Bodegas disponibles para actualizar", bodegasDisponiblesParaActualizar);
    }

    /* localhost:8080/vinos/seleccionarBodega/Bodega[1*]

    @GetMapping("/seleccionarBodega")
    public BodegaResponse tomarSeleccionBodega(Bodega bodega) {

    }
    */

}