/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import util.DBConnection;

/**
 *
 * @author estudiante
 */
public class EmpleadoDAOImpl implements EmpleadoDAO{

    private String sql = "";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    @Override
    public int save(Empleado empleado) {
        
        int row = 0;
        sql = "INSERT INTO empleados (nombre, dpto) VALUES (?, ?)";
        connection = DBConnection.getConnection();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getDpto());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public int update(Empleado empleado) {

        int row = 0;
        sql = "UPDATE empleados SET nombre = ?, dpto = ? WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getDpto());
            preparedStatement.setInt(3, empleado.getId());
            row = preparedStatement.executeUpdate();
            preparedStatement.close(); 
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(int idEmpleado) {

        int row = 0;
        sql= "DELETE FROM empleados WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idEmpleado);
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            
        } catch (SQLException ex) {
         ex.printStackTrace();
        }
        
        return row;
    }

    @Override
    public List<Empleado> getAll() {

        List<Empleado> list = new ArrayList();
        sql= "SELECT * FROM empleados";
        connection = DBConnection.getConnection();
        try {
           preparedStatement = connection.prepareStatement(sql);
           resultSet = preparedStatement.executeQuery(); 
           
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt(1));
                empleado.setNombre(resultSet.getString(2));
                empleado.setDpto(resultSet.getString(3));
                list.add(empleado);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Empleado getById(int idEmpleado) {
        Empleado empleado = null;
        sql = "SELECT * FROM empleados WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEmpleado);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                empleado = new Empleado();
                empleado.setId(resultSet.getInt(1));
                empleado.setNombre(resultSet.getString(2));
                empleado.setDpto(resultSet.getString(3));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empleado;
    }
    
  
}
