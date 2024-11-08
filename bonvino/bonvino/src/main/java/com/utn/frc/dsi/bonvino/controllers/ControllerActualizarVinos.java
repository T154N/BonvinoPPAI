package com.utn.frc.dsi.bonvino.controllers;

import com.utn.frc.dsi.bonvino.entities.Bodega;
import com.utn.frc.dsi.bonvino.services.BodegaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vinos")
@RequiredArgsConstructor
public class ControllerActualizarVinos {

    private final BodegaServiceImpl bodegaService;

    @GetMapping("/actualizarVinos")
    public ResponseEntity buscarBodegasParaActualizar() {

        LocalDate fechaActual = LocalDate.now();

        List<Bodega> bodegasBdd = bodegaService.findAll();
        List<String> bodegasDisponiblesParaActualizar = new ArrayList<>();

        for (Bodega bodegaBdd : bodegasBdd) {
            if (bodegaBdd.disponibleActualizar(fechaActual)) {
                bodegasDisponiblesParaActualizar.add(bodegaBdd.getNombre());
            }
        }

        if (bodegasDisponiblesParaActualizar.isEmpty()) {
            // Devuelve 204 No Content si no hay bodegas disponibles para actualizar
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bodegasDisponiblesParaActualizar);
        } else {
            // Devuelve 200 OK con la lista de nombres de bodegas
            return ResponseEntity.ok(bodegasDisponiblesParaActualizar);
        }

    }

    /* localhost:8080/vinos/seleccionarBodega/Bodega[1*]

    @GetMapping("/seleccionarBodega")
    public BodegaResponse tomarSeleccionBodega(Bodega bodega) {

    }
    */

}