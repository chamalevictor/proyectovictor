// https://github.com/BranislavLazic/JdbcTutorials/blob/master/src/main/java/com/daoimpl/PersonDaoImpl.java


package com.pruebavictor.proyectovictor.modelos;

import com.pruebavictor.proyectovictor.controladores.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion implements Transacciones{

    private final String db = "jdbc:oracle:thin:@localhost:1521:XE";
    
    private Connection conectar(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(db);
            System.out.println("Conexion Exitos");
        } catch (SQLException e){
           e.printStackTrace();
        }
        return conn;
    } 
    
    @Override
    public List<Persona> obtenerTodo() {
        Connection _conn = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try {
            _conn = DriverManager.getConnection(db,"system", "Admin123.");
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        List <Persona> listaPersonas = new ArrayList<Persona>();
        String selectAll = "SELECT * FROM prueba";
        try {
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(selectAll);
            
            while(rs.next()){
                Persona persona = new Persona(rs.getInt("id_prueba"), rs.getString("nombre"), rs.getString("apellido"));
                System.out.println(rs.getString("nombre") + rs.getString("apellido"));
                System.out.println(rs.getInt("id_prueba"));
                  
                listaPersonas.add(persona);
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        try {
            _conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return listaPersonas;
    }

    @Override
    public Persona obtenerPersona(int id) {
                Connection _conn = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e){
            e.printStackTrace();
        }
        
        try {
            _conn = DriverManager.getConnection(db,"system", "Admin123.");
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        Persona p = null;
        
        String sql = "SELECT * FROM prueba WHERE id_prueba = ? ";
        
        try {
            
            PreparedStatement st = _conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            System.out.println("***** llegamos aqui ******");
            p = new Persona(rs.getInt("id_prueba"), rs.getString("nombre"), rs.getString("apellido"));
  
            _conn.close();
 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(p.getApellido());
        return p;
    }

    @Override
    public void insertar(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main (String[] args){
        Conexion conexion = new Conexion();
        conexion.obtenerTodo();
    }
    
}
