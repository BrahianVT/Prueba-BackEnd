package edu.exercise.resuelve;

/**
 * Clase que representa una entidad jugador
 * @Author Brahian Velazquez
 * */
public class Jugador {
    private String nombre;
    private String nivel;
    private int goles;
    private Float sueldo;
    private Float bono;
    private Float bonoReal;
    private Float sueldoCompleto;

    private String equipo;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public Float getBono() {
        return bono;
    }

    public void setBono(Float bono) {
        this.bono = bono;
    }

    public Float getBonoReal() {
        return bonoReal;
    }

    public void setBonoReal(Float bonoReal) {
        this.bonoReal = bonoReal;
    }

    public Float getSueldoCompleto() {
        return sueldoCompleto;
    }

    public void setSueldoCompleto(Float sueldoCompleto) {
        this.sueldoCompleto = sueldoCompleto;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Jugador() {}

    public Jugador(String nombre, String nivel, int goles, float sueldo, float bono,float bonoReal, float sueldoCompleto, String equipo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.goles = goles;
        this.sueldo = sueldo;
        this.bono = bono;
        this.bonoReal = bonoReal;
        this.sueldoCompleto = sueldoCompleto;
        this.equipo = equipo;
    }
}
