package edu.exercise.resuelve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para el calculo de los salarios
 * */
public class CalcularSueldoTest {
    CalcularSueldo calcularSueldo;

    @BeforeEach
    void setup(){
        calcularSueldo = new CalcularSueldo();
    }

    @Test
    public void testUnJugadorUnEquipo(){
        Jugador jug = new Jugador("Prueba1", "A", 5,10000, 1000,0,0,"azul");
        List<Jugador> lista = new ArrayList<Jugador>();
        lista.add(jug);
        calcularSueldo.llenarListaNiveles();
        assertEquals("A", calcularSueldo.getListaNiveles().get(0).getNivel());

        calcularSueldo.calcularGoles(lista);
        calcularSueldo.calcularPorcetajesBonoEquipo(lista);
        assertEquals(100.0f ,calcularSueldo.getPorcentajeBonoEquipo().get("azul"));
        assertEquals(5 ,calcularSueldo.getTotalGolesMesNecesarios().get("azul"));
        assertEquals(5,calcularSueldo.getTotalGolesPorMes().get("azul"));

        calcularSueldo.calcularSalario(lista);
        assertEquals(11000f, lista.get(0).getSueldoCompleto());
        assertEquals(1000f, lista.get(0).getBonoReal());
    }

    @Test
    public void testVariosJugadoresUnEquipo(){
        Jugador jug = new Jugador("Juan", "A", 6,50000, 1000,0,0,"azul");
        Jugador jug2 = new Jugador("Pedro", "B", 7,50000, 2000,0,0,"azul");
        Jugador jug3 = new Jugador("Martín", "C", 16,50000, 3000,0,0,"azul");
        Jugador jug4 = new Jugador("Luis", "Cuauh", 19,50000, 10000,0,0,"azul");
        List<Jugador> lista = new ArrayList<Jugador>();
        lista.add(jug); lista.add(jug2); lista.add(jug3); lista.add(jug4);
        calcularSueldo.llenarListaNiveles();
        calcularSueldo.calcularGoles(lista);
        calcularSueldo.calcularPorcetajesBonoEquipo(lista);

        assertEquals(96f ,calcularSueldo.getPorcentajeBonoEquipo().get("azul"));
        assertEquals(50 ,calcularSueldo.getTotalGolesMesNecesarios().get("azul"));
        assertEquals(48,calcularSueldo.getTotalGolesPorMes().get("azul"));

        calcularSueldo.calcularSalario(lista);
        assertEquals(9550f, lista.get(3).getBonoReal());  // Luis
        assertEquals(59550f, lista.get(3).getSueldoCompleto());

        assertEquals(2940f, lista.get(2).getBonoReal());  // Martin
        assertEquals(52940f, lista.get(2).getSueldoCompleto());

        assertEquals(1660f, lista.get(1).getBonoReal());  // Pedro
        assertEquals(51660f, lista.get(1).getSueldoCompleto());

        assertEquals(980f, lista.get(0).getBonoReal());  // Juan
        assertEquals(50980f, lista.get(0).getSueldoCompleto());
    }

    @Test
    public void testVariosJugadoresVariosEquipos(){
        Jugador jug = new Jugador("Juan Perez", "C", 10,50000, 25000,0,0,"rojo");
        Jugador jug2 = new Jugador("EL Cuauh", "Cuauh", 30,100000, 30000,0,0,"azul");
        Jugador jug3 = new Jugador("Cosme Fulamito", "A", 7,20000, 10000,0,0,"azul");
        Jugador jug4 = new Jugador("El Rulo", "B", 9,30000, 15000,0,0,"rojo");
        List<Jugador> lista = new ArrayList<Jugador>();
        lista.add(jug); lista.add(jug2); lista.add(jug3); lista.add(jug4);
        calcularSueldo.llenarListaNiveles();
        calcularSueldo.calcularGoles(lista);
        calcularSueldo.calcularPorcetajesBonoEquipo(lista);

        assertEquals(100f ,calcularSueldo.getPorcentajeBonoEquipo().get("azul"));
        assertEquals(25 ,calcularSueldo.getTotalGolesMesNecesarios().get("azul"));
        assertEquals(37,calcularSueldo.getTotalGolesPorMes().get("azul"));
        assertEquals(76f ,calcularSueldo.getPorcentajeBonoEquipo().get("rojo"));
        assertEquals(25 ,calcularSueldo.getTotalGolesMesNecesarios().get("rojo"));
        assertEquals(19,calcularSueldo.getTotalGolesPorMes().get("rojo"));

        calcularSueldo.calcularSalario(lista);
        assertEquals(12450f, lista.get(3).getBonoReal());  // el rulo
        assertEquals(42450f, lista.get(3).getSueldoCompleto());

        assertEquals(10000f, lista.get(2).getBonoReal());  // Cosme Fulamito
        assertEquals(30000f, lista.get(2).getSueldoCompleto());

        assertEquals(30000f, lista.get(1).getBonoReal());  // EL Cuauh
        assertEquals(130000f, lista.get(1).getSueldoCompleto());

        assertEquals(17750f, lista.get(0).getBonoReal());  // Juan Perez
        assertEquals(67750f, lista.get(0).getSueldoCompleto());
    }

}