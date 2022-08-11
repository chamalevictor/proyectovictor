
package com.pruebavictor.proyectovictor.controladores;

public class Persona {
    private int id_prueba;
    private String nombre;
    private String apellido;
    
    public Persona(){
        
    }

    public Persona(int id, String nombre, String apellido) {
        this.id_prueba = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id_prueba;
    }

    public void setId(int id) {
        this.id_prueba = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    
}
