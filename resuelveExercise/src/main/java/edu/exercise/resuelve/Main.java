package edu.exercise.resuelve;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Clase principal que inicial el programa donde se leer la entrada del archivo Json y donde se guarda el resultado
 * @author Brahian Velazquez
 * */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public  static void main(String[] args) {

        JsonUtilities cargar = new JsonUtilities();
        LoadProperties properties = new LoadProperties();

        List<Jugador> jugadores = cargar.cargarArchivoJson(properties.getPropFile().getProperty("fileEntrada"));

        logger.debug("ARCHIVO CARGADO CORRECTAMENTE, PROCESANDO ...");


        CalcularSueldo calcularSueldo = new CalcularSueldo();
        calcularSueldo.llenarListaNiveles();
        calcularSueldo.calcularGoles(jugadores);
        calcularSueldo.calcularSalario(jugadores);
        cargar.guardarArchivoJsonSalida(properties.getPropFile().getProperty("fileSalida"), jugadores);

        logger.debug("ARCHIVO GUARDADO CORRECTAMENTE PROCESANDO ...");
    }
}
