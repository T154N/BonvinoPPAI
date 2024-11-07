package com.utn.frc.dsi.bonvino.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Vinos")
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "aniada")
    private Integer aniada;
    @Column(name = "imagenEtiqueta")
    private String imagenEtiqueta;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "notaDeCataBodega")
    private Integer notaDeCataBodega;
    @Column(name = "precioArs")
    private Float precioArs;
    @ManyToOne
    @JoinColumn(name = "idBodega")
    private Bodega idBodega;
    @ManyToMany
    private List<Varietal> varietales;
    @ManyToMany
    private List<Maridaje> maridajes;
    @OneToMany
    private List<Resenia> resenias;

}