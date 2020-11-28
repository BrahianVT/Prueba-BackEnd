package edu.exercise.resuelve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalcularSueldo {
    private Map<String, Integer> totalGolesMesNecesarios = new HashMap<>();
    private Map<String, Integer> totalGolesPorMes = new HashMap<>();
    private Map<String, Float> porcentajeBonoEquipo = new HashMap<>();
    private List<Nivel> listaNiveles = new ArrayList<Nivel>();

    public void calcularSalario(List<Jugador> jugadores){
        calcularPorcetajesBonoEquipo(jugadores);
        for(Jugador jugador: jugadores){
            float bonoBase = jugador.getBono() /2;
            float bonoReal = (bonoBase * calcularPorcentajeBonoJugador(jugador) / 100) + (bonoBase * porcentajeBonoEquipo.get(jugador.getEquipo()) /100);
            jugador.setBonoReal(bonoReal);
            jugador.setSueldoCompleto(bonoReal + jugador.getSueldo());
        }
    }
    public void calcularPorcetajesBonoEquipo(List<Jugador> jugadores){
        for(Map.Entry<String, Integer> equipo : totalGolesPorMes.entrySet()){
            if(equipo.getValue() >= totalGolesMesNecesarios.get(equipo.getKey()))
                porcentajeBonoEquipo.put(equipo.getKey(), 100f);
            else {
                porcentajeBonoEquipo.put(equipo.getKey(), equipo.getValue() * 100 / (float) totalGolesMesNecesarios.get(equipo.getKey()));
            }
        }
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
           Integer golesNecesariosPorEquipo = totalGolesMesNecesarios.getOrDefault(jugador.getEquipo(), 0) +
                   obtenerGolesPorNivel(jugador.getNivel());
           Integer golesPorEquipo = totalGolesPorMes.getOrDefault(jugador.getEquipo(), 0) + jugador.getGoles();
           totalGolesMesNecesarios.put(jugador.getEquipo(), golesNecesariosPorEquipo);
           totalGolesPorMes.put(jugador.getEquipo(), golesPorEquipo);
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

    public Map<String, Integer> getTotalGolesMesNecesarios() {
        return totalGolesMesNecesarios;
    }

    public void setTotalGolesMesNecesarios(Map<String, Integer> totalGolesMesNecesarios) {
        this.totalGolesMesNecesarios = totalGolesMesNecesarios;
    }

    public Map<String, Integer> getTotalGolesPorMes() {
        return totalGolesPorMes;
    }

    public void setTotalGolesPorMes(Map<String, Integer> totalGolesPorMes) {
        this.totalGolesPorMes = totalGolesPorMes;
    }

    public Map<String, Float> getPorcentajeBonoEquipo() {
        return porcentajeBonoEquipo;
    }

    public void setPorcentajeBonoEquipo(Map<String, Float> porcentajeBonoEquipo) {
        this.porcentajeBonoEquipo = porcentajeBonoEquipo;
    }

    public List<Nivel> getListaNiveles() {
        return listaNiveles;
    }

    public void setListaNiveles(List<Nivel> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }
}
