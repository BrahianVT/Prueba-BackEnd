package edu.exercise.resuelve.restcontroller;

import edu.exercise.resuelve.Main;
import edu.exercise.resuelve.Services.CalcularSueldo;
import edu.exercise.resuelve.entities.Jugador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/nomina")
@RestController
public class NominaController {
    private static final Logger logger = LogManager.getLogger(NominaController.class);
    @Autowired
    CalcularSueldo calcularSueldo;
    @PostMapping("/calculaNomina")
    public ResponseEntity<List<Jugador>> calcularNominaJugadores( @RequestBody List<Jugador> jugadores){

        calcularSueldo.llenarListaNiveles();
        calcularSueldo.calcularGoles(jugadores);
        calcularSueldo.calcularSalario(jugadores);
        if(jugadores == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Jugador>>(jugadores, HttpStatus.OK);
    }
}
