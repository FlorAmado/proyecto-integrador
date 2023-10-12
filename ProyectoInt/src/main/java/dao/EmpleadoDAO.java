/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Empleado;

/**
 *
 * @author estudiante
 */
public interface EmpleadoDAO {
    
    //guardar empleado
    int save (Empleado empleado);
    
    //editar empleado
    int update (Empleado empleado);
    
    //eliminar empleado
    int delete (int idEmpleado);

    //obetener lista de empleados
    List<Empleado> getAll();
    
    //obtener por id
    Empleado getById(int idEmpleado);
    

}
