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
public class Ruta implements Serializable {
    private int id_ruta;
    private String origen;
    private String destino;
    private String hora;
    private String fecha;
    private int id_camionero;

    public Ruta() {
        this.id_ruta = 0;
        this.origen = "";
        this.destino = "";
        this.hora = "";
        this.fecha = "";
        this.id_camionero = 0;
    }
    public Ruta( String origen, String destino, String hora, String fecha, int id_camionero) {
        this.id_ruta = 0;
        this.origen = origen;
        this.destino = destino;
        this.hora = hora;
        this.fecha = fecha;
        this.id_camionero = id_camionero;
    }

    public void setId_camionero(int id_camionero) {
        this.id_camionero = id_camionero;
    }

    public int getId_camionero() {
        return id_camionero;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
