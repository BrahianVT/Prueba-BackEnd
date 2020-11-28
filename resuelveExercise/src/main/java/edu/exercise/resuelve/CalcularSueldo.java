package edu.exercise.resuelve;

import java.util.ArrayList;
import java.util.List;

public class CalcularSueldo {
    private float totalGolesMesNecesarios;
    private float totalGolesPorMes;
    private float porcentajeBonoEquipo;
    private List<Nivel> listaNiveles = new ArrayList<Nivel>();


    
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
