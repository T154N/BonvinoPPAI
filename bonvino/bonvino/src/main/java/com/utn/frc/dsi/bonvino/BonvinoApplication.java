package com.utn.frc.dsi.bonvino;

import com.utn.frc.dsi.bonvino.entities.Vino;
import com.utn.frc.dsi.bonvino.services.interfaces.VinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BonvinoApplication implements CommandLineRunner {

	@Autowired
	private VinoService vinoService;

	public static void main(String[] args) {
		SpringApplication.run(BonvinoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Ahora puedes acceder al servicio y ejecutar la lógica
		List<Vino> vinos = vinoService.findAll();

		for (Vino elem : vinos){
			System.out.println("----------------------------------");
			System.out.println(elem.getNombre());
			System.out.println(elem.getBodega().getNombre());
		}

	}
}
