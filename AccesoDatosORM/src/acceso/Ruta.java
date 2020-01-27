package acceso;
// Generated 17-ene-2020 21:44:16 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ruta generated by hbm2java
 */
public class Ruta  implements java.io.Serializable {


     private Integer idRuta;
     private Camionero camionero;
     private String origen;
     private String destino;
     private String hora;
     private String fecha;
     private Set paquetes = new HashSet(0);

    public Ruta() {
    }

    public Ruta(Camionero camionero, String origen, String destino, String hora, String fecha, Set paquetes) {
       this.camionero = camionero;
       this.origen = origen;
       this.destino = destino;
       this.hora = hora;
       this.fecha = fecha;
       this.paquetes = paquetes;
    }
   
    public Integer getIdRuta() {
        return this.idRuta;
    }
    
    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
    public Camionero getCamionero() {
        return this.camionero;
    }
    
    public void setCamionero(Camionero camionero) {
        this.camionero = camionero;
    }
    public String getOrigen() {
        return this.origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return this.destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Set getPaquetes() {
        return this.paquetes;
    }
    
    public void setPaquetes(Set paquetes) {
        this.paquetes = paquetes;
    }




}

