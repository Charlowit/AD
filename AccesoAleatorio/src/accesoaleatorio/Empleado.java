/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoaleatorio;

/**
 *
 * @author Charlowit
 */
public class Empleado {
    private int id;
    private String apellido;
    private int depepartamento;
    private double salario;

    public Empleado() {
        this.id = 0;
        this.apellido = "";
        this.depepartamento = 0;
        this.salario = 0;        
    }

    public Empleado(int id, String apellido, int depepartamento, double salario) {
        this.id = id;
        this.apellido = apellido;
        this.depepartamento = depepartamento;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDepepartamento() {
        return depepartamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDepepartamento(int depepartamento) {
        this.depepartamento = depepartamento;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
