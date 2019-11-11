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
public class Camionero implements Serializable {
   
    private int id_camionero;
    private String nombre;
    private String apellidos;
    private int edad;
    private double salario;
    private int id_camion;

    public Camionero(int id_camionero, String nombre, String apellidos, int edad, double salario, int id_camion) {
        this.id_camionero = id_camionero;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salario = salario;
        this.id_camion = id_camion;
    }

    public int getId_camion() {
        return id_camion;
    }

    public void setId_camion(int id_camion) {
        this.id_camion = id_camion;
    }

    public void setId_camionero(int id_camionero) {
        this.id_camionero = id_camionero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId_camionero() {
        return id_camionero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }
    
    
}
