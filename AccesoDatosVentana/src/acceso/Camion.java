package acceso;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlowit
 */
public class Camion implements Serializable {
    
    private int id_camion;
    private String nombre_camion;
    private int velocidad_maxima;
    private int mma;
    private double litros_tanque;

    public Camion(int id_camion, String nombre_camion, int velocidad_maxima, int mma, double litros_tanque) {
        this.id_camion = id_camion;
        this.nombre_camion = nombre_camion;
        this.velocidad_maxima = velocidad_maxima;
        this.mma = mma;
        this.litros_tanque = litros_tanque;
    }


    public void setId_camion(int id_camion) {
        this.id_camion = id_camion;
    }

    public void setNombre_camion(String nombre_camion) {
        this.nombre_camion = nombre_camion;
    }

    public void setVelocidad_maxima(int velocidad_maxima) {
        this.velocidad_maxima = velocidad_maxima;
    }

    public void setMma(int mma) {
        this.mma = mma;
    }

    public void setLitros_tanque(double litros_tanque) {
        this.litros_tanque = litros_tanque;
    }

    public int getId_camion() {
        return id_camion;
    }

    public String getNombre_camion() {
        return nombre_camion;
    }

    public int getVelocidad_maxima() {
        return velocidad_maxima;
    }

    public int getMma() {
        return mma;
    }

    public double getLitros_tanque() {
        return litros_tanque;
    }


    
    



   
}