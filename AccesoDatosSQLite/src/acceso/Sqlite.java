/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Charlowit
 */
public class Sqlite {
    
    
    public static Connection getConnection() throws SQLException{
        
                
        String url = "jdbc:sqlite:./envios.db";
        Connection conn = DriverManager.getConnection(url);
        System.out.println("La conexion se ha realizado correctamente");
        
        return conn;
    }
    
    public static int insertarCamion(Camion aux) throws SQLException{
    
            int id = 0;
            Connection conn = getConnection();
            String query = "INSERT INTO camion(nombre_camion,velocidad_maxima,mma,litros_tanque) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query); 
            pstmt.setString(1, aux.getNombre_camion());
            pstmt.setInt(2, aux.getVelocidad_maxima());
            pstmt.setInt(3, aux.getMma());
            pstmt.setDouble(4, aux.getLitros_tanque());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();	
            if(rs.next()){
		id=rs.getInt(1);
            }
            pstmt.close();
            conn.close();
            return id;
                   
        
    }
    
    public static void leerCamion(ArrayList<Camion> camiones) throws SQLException{
            Connection conn = getConnection();
            String query = "SELECT * FROM camion";
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(query);
                        
            while(rs.next()){
                Camion aux = new Camion();
                aux.setId_camion(rs.getInt("id_camion"));
                aux.setNombre_camion( rs.getString("nombre_camion"));
                aux.setVelocidad_maxima(rs.getInt("velocidad_maxima"));
                aux.setMma(rs.getInt("mma"));
                aux.setLitros_tanque(rs.getDouble("litros_tanque"));
                
                camiones.add(aux);
                
            }
            rs.close();
            smt.close();
            conn.close();
    }
    
    public static void borrarCamion(Camion aux) throws SQLException{
            
            String sql = "DELETE FROM camion WHERE id_camion = ?";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, aux.getId_camion());
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
 
    }
    public static void modificarCamion(Camion aux) throws SQLException{
                
            Connection conn = getConnection();
            String query = "UPDATE camion SET nombre_camion = ? , "
                + "velocidad_maxima = ? , " + " mma = ? , " + " litros_tanque = ? "
                + "WHERE id_camion = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, aux.getNombre_camion());
            pstmt.setInt(2, aux.getVelocidad_maxima());
            pstmt.setInt(3, aux.getMma());
            pstmt.setDouble(4, aux.getLitros_tanque());
            pstmt.setInt(5, aux.getId_camion());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
    }
    public static int insertarCamionero(Camionero aux) throws SQLException{
            int id = 0;
            Connection conn = getConnection();
            String query = "INSERT INTO camionero(nombre,apellidos,edad,salario,id_camion) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, aux.getNombre());
            pstmt.setString(2, aux.getApellidos());
            pstmt.setInt(3, aux.getEdad());
            pstmt.setDouble(4, aux.getSalario());
            pstmt.setInt(5, aux.getId_camion());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();	
            
            if(rs.next()){
		id=rs.getInt(1);
            }
            
            pstmt.close();
            conn.close();
            
            return id;
                   
        
    }
    
    public static void modificarCamionero(Camionero aux) throws SQLException{
                
            Connection conn = getConnection();
            String query = "UPDATE camionero SET nombre = ? , "
                + "apellidos = ? , " + "edad = ? , " + "salario = ? , " + "id_camion = ? "
                + "WHERE id_camionero = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, aux.getNombre());
            pstmt.setString(2, aux.getApellidos());
            pstmt.setInt(3, aux.getEdad());
            pstmt.setDouble(4, aux.getSalario());
            pstmt.setInt(5, aux.getId_camion());
            
            pstmt.setInt(6, aux.getId_camionero());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
    }
    public static void leerCamionero(ArrayList<Camionero> camioneros) throws SQLException{
            Connection conn = getConnection();
            String query = "SELECT * FROM camionero";
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(query);
                        
            while(rs.next()){
                Camionero aux = new Camionero();
                aux.setId_camionero(rs.getInt("id_camionero"));
                aux.setNombre( rs.getString("nombre"));
                aux.setApellidos(rs.getString("apellidos"));
                aux.setEdad(rs.getInt("edad"));
                aux.setSalario(rs.getDouble("salario"));
                aux.setId_camion(rs.getInt("id_camion"));
                
                camioneros.add(aux);
                
            }
            rs.close();
            smt.close();
            conn.close();
    }
    
    public static void borrarCamionero(Camionero aux) throws SQLException{
            
            String sql = "DELETE FROM camionero WHERE id_camionero = ?";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, aux.getId_camionero());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
 
    }
    
    public static int insertarRuta(Ruta aux) throws SQLException{
            int id = 0;
            Connection conn = getConnection();
            String query = "INSERT INTO ruta(origen,destino,hora,fecha,id_camionero) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, aux.getOrigen());
            pstmt.setString(2, aux.getDestino());
            pstmt.setString(3, aux.getHora());
            pstmt.setString(4, aux.getFecha());
            pstmt.setInt(5, aux.getId_camionero());
            
            pstmt.executeUpdate();
            
                        ResultSet rs = pstmt.getGeneratedKeys();	
            
            if(rs.next()){
		id=rs.getInt(1);
            }
            
            pstmt.close();
            conn.close();
            
            return id;
                   
        
    }
    
    public static void modificarRuta(Ruta aux) throws SQLException{
                
            Connection conn = getConnection();
            String query = "UPDATE ruta SET origen = ? , "
                + "destino = ? , " + "hora = ? , " + "fecha = ? , " + "id_camionero = ? "
                + "WHERE id_ruta = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, aux.getOrigen());
            pstmt.setString(2, aux.getDestino());
            pstmt.setString(3, aux.getHora());
            pstmt.setString(4, aux.getFecha());
            pstmt.setInt(5, aux.getId_camionero());
            
            pstmt.setInt(6, aux.getId_ruta());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
    }
    public static void leerRuta(ArrayList<Ruta> rutas) throws SQLException{
            Connection conn = getConnection();
            String query = "SELECT * FROM ruta";
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(query);
                        
            while(rs.next()){
                Ruta aux = new Ruta();
                aux.setId_ruta(rs.getInt("id_ruta"));
                aux.setOrigen( rs.getString("origen"));
                aux.setDestino(rs.getString("destino"));
                aux.setHora(rs.getString("hora"));
                aux.setFecha(rs.getString("fecha"));
                aux.setId_camionero(rs.getInt("id_camionero"));
                
                rutas.add(aux);
                
            }
            rs.close();
            smt.close();
            conn.close();
    }
    
    public static void borrarRuta(Ruta aux) throws SQLException{
            
            String sql = "DELETE FROM ruta WHERE id_ruta = ?";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, aux.getId_ruta());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
 
    }
    public static int insertarPaquete(Paquete aux) throws SQLException{
            int id = 0;
            Connection conn = getConnection();
            String query = "INSERT INTO paquete(peso,altura,ancho,profundidad,id_ruta) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setDouble(1, aux.getPeso());
            pstmt.setDouble(2, aux.getAltura());
            pstmt.setDouble(3, aux.getAncho());
            pstmt.setDouble(4, aux.getProfundidad());
            pstmt.setInt(5, aux.getId_ruta());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();	
            
            if(rs.next()){
		id=rs.getInt(1);
            }
            pstmt.close();
            conn.close();
            
            return id;
                   
        
    }
    
    public static void modificarPaquete(Paquete aux) throws SQLException{
                
            Connection conn = getConnection();
            String query = "UPDATE paquete SET peso = ? , "
                + "altura = ? , " + "ancho = ? , " + "profundidad = ? , " + "id_ruta = ? "
                + "WHERE id_paquete = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setDouble(1, aux.getPeso());
            pstmt.setDouble(2, aux.getAltura());
            pstmt.setDouble(3, aux.getAncho());
            pstmt.setDouble(4, aux.getProfundidad());
            pstmt.setInt(5, aux.getId_ruta());
            
            pstmt.setInt(6, aux.getId_paquete());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
    }
    
    public static void leerPaquete(ArrayList<Paquete> paquetes) throws SQLException{
            Connection conn = getConnection();
            String query = "SELECT * FROM paquete";
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(query);
                        
            while(rs.next()){
                Paquete aux = new Paquete();
                aux.setId_paquete(rs.getInt("id_paquete"));
                aux.setPeso(rs.getDouble("peso"));
                aux.setAltura(rs.getDouble("altura"));
                aux.setAncho(rs.getDouble("ancho"));
                aux.setProfundidad(rs.getDouble("profundidad"));
                aux.setId_ruta(rs.getInt("id_ruta"));
                
                paquetes.add(aux);
                
            }
            rs.close();
            smt.close();
            conn.close();
    }
    
    public static void borrarPaquete(Paquete aux) throws SQLException{
            
            String sql = "DELETE FROM paquete WHERE id_paquete = ?";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, aux.getId_paquete());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
 
    }
    
    

}
