package acceso;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlowit
 */
public class Paquete implements Serializable {
    
    private int id_paquete;
    private double peso;
    private double altura;
    private double ancho;
    private double profundidad;
    private int id_ruta;

    public Paquete(int id_paquete, double peso, double altura, double ancho, double profundidad, int id_ruta) {
        this.id_paquete = id_paquete;
        this.peso = peso;
        this.altura = altura;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.id_ruta = id_ruta;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getAncho() {
        return ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }


    
    
}
