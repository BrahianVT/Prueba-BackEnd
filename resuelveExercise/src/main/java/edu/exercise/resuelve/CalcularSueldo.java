package edu.exercise.resuelve;

import java.util.ArrayList;
import java.util.List;

public class CalcularSueldo {
    private float totalGolesMesNecesarios;
    private float totalGolesPorMes;
    private float porcentajeBonoEquipo;
    private List<Nivel> listaNiveles = new ArrayList<Nivel>();



    public void calcularSalario(List<Jugador> jugadores){
        calcularPorcetajesBonoEquipo();
        for(Jugador jugador: jugadores){
            float bonoBase = jugador.getBono() /2;
            float bonoReal = (bonoBase * calcularPorcentajeBonoJugador(jugador) / 100) + (bonoBase * porcentajeBonoEquipo /100);
            jugador.setBonoReal(bonoReal);
            jugador.setSueldoCompleto(bonoReal + jugador.getSueldo());
        }
    }
    public void calcularPorcetajesBonoEquipo(){
        if(totalGolesPorMes >= totalGolesMesNecesarios)
            porcentajeBonoEquipo = 100.f;
        else
            porcentajeBonoEquipo = (totalGolesPorMes * 100) / totalGolesMesNecesarios;

    }
    public float calcularPorcentajeBonoJugador(Jugador jugador){
        int golesJugador = jugador.getGoles();
        int golesNecesarios = obtenerGolesPorNivel(jugador.getNivel());

        if(golesJugador >= golesNecesarios) return 100.f;
        else
            return (golesJugador * 100) / golesNecesarios;
    }
    public void calcularGoles(List<Jugador> jugadores){
        for(Jugador jugador: jugadores){
            totalGolesMesNecesarios+= obtenerGolesPorNivel(jugador.getNivel());
            totalGolesPorMes+= jugador.getGoles();
        }
    }
    public int obtenerGolesPorNivel(String nivel){
        return listaNiveles.stream()
                .filter(index -> index.getNivel().contains(nivel))
                .findFirst().orElse(null)
                .getGolesPorMes();
    }
    public void llenarListaNiveles(){
        listaNiveles.add(new Nivel("A", 5));
        listaNiveles.add(new Nivel("B", 10));
        listaNiveles.add(new Nivel("C", 15));
        listaNiveles.add(new Nivel("Cuauh", 20));
    }


    public float getTotalGolesMesNecesarios() {
        return totalGolesMesNecesarios;
    }

    public void setTotalGolesMesNecesarios(float totalGolesMesNecesarios) {
        this.totalGolesMesNecesarios = totalGolesMesNecesarios;
    }

    public float getTotalGolesPorMes() {
        return totalGolesPorMes;
    }

    public void setTotalGolesPorMes(float totalGolesPorMes) {
        this.totalGolesPorMes = totalGolesPorMes;
    }

    public float getPorcentajeBonoEquipo() {
        return porcentajeBonoEquipo;
    }

    public void setPorcentajeBonoEquipo(float porcentajeBonoEquipo) {
        this.porcentajeBonoEquipo = porcentajeBonoEquipo;
    }

    public List<Nivel> getListaNiveles() {
        return listaNiveles;
    }

    public void setListaNiveles(List<Nivel> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }
}
