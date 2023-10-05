/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author estudiante
 */
public class Empleado {

    private int id;
    private String nombre;
    private String dpto;

    public Empleado() {

    }

    public Empleado(int id, String nombre, String dpto) {
        this.id = id;
        this.nombre = nombre;
        this.dpto = dpto;
    }//constructor para buscar o act

    public Empleado(String nombre, String dpto) {
        this.nombre = nombre;
        this.dpto = dpto;
    } //agregar

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", dpto=" + dpto + '}';
    }
    
    
}
