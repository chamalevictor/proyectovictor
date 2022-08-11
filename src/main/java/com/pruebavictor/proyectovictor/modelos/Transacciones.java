
package com.pruebavictor.proyectovictor.modelos;

import com.pruebavictor.proyectovictor.controladores.Persona;
import java.util.List;

public interface Transacciones {
    
    public List <Persona> obtenerTodo();
    public Persona obtenerPersona(int id);
    public void insertar (Persona p);
    public void actualizar (Persona p);
    public void eliminar (int id);
}
