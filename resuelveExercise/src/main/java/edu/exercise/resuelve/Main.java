package edu.exercise.resuelve;

import java.util.List;

/**
 * Clase principal que inicial el programa donde se leer la entrada del archivo Json y donde se guarda el resultado
 * @author Brahian Velazquez
 * */
public class Main {

    public  static void main(String[] args) {
        Main main = new Main();

        JsonUtilities cargar = new JsonUtilities();
        List<Jugador> jugadores = cargar.cargarArchivoJson("input.json");

        System.out.println("ARCHIVO CARGADO CORRECTAMENTE PROCESANDO ...");
        CalcularSueldo calcularSueldo = new CalcularSueldo();
        calcularSueldo.llenarListaNiveles();
        calcularSueldo.calcularGoles(jugadores);
        calcularSueldo.calcularSalario(jugadores);
        cargar.guardarArchivoJsonSalida("output.json", jugadores);

        System.out.println("ARCHIVO GUARDADO CORRECTAMENTE PROCESANDO ...");
    }
}
