/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EmpleadoDAO;
import dao.EmpleadoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import util.DBConnection;

/**
 *
 * @author estudiante
 */
@WebServlet(name = "EmpleadoController", urlPatterns = {"/EmpleadoController"})
public class EmpleadoController extends HttpServlet {

   EmpleadoDAO empleadoDao = new EmpleadoDAOImpl();
   
    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       // DBConnection.getConnection();
       
       String accion = request.getParameter("accion");
       
        if (accion == null || accion.isEmpty()) {
            //ir a la lista
            listarEmpleados(request,response);
            
        }else{
            switch (accion) {
                case "nuevo":
                    nuevoEmpleado(request,response);
                    break; 
                case "edit":
                    editEmpleado(request,response);
                    break;
                case "delete":
                    deleteEmpleado(request,response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        Empleado empleado = null;
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String dpto = request.getParameter("dpto");
        
        if (id == null || id.isEmpty()) {
            //insert
            empleado = new Empleado(nombre, dpto);
            empleadoDao.save(empleado);
            listarEmpleados(request, response);
            
        }else{
            // empleado = new Empleado(Integer.paramInt(id), nombre, dpto);
            //empleadoDao.update(empleado);
            //listarEmpleados(request, response);
            
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Empleado> list = new ArrayList<>();
        list = empleadoDao.getAll();
        request.setAttribute("list.jsp",list);
        
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void nuevoEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("form-empleado.jsp");
    }

    private void editEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("form-empleado.jsp").forward(request, response);

    }

    private void deleteEmpleado(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
