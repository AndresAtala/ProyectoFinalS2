// ModificarAdministradorServlet
package com.gestionEmpresa.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.gestionEmpresa.model.Administrador;
import com.gestionEmpresa.model.data.DBGenerator;
import com.gestionEmpresa.model.data.DAO.AdministradorDAO;
import org.jooq.DSLContext;

@WebServlet("/ModificarAdministradorServlet")
public class ModificarAdministradorServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String rol = request.getParameter("rol");

        // Crear objeto Administrador
        Administrador admin = new Administrador(rut, nombre, apellido, telefono, rol);

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("Proyecto");

            // Crear una instancia del DAO
            AdministradorDAO adminDAO = new AdministradorDAO(query);

            // Lógica para modificar el administrador
            boolean modificacionExitosa = adminDAO.modificarAdministrador(admin);

            // Redireccionar a una página de éxito o mostrar un mensaje
            if (modificacionExitosa) {
                response.sendRedirect("exito.jsp");
            } else {
                // Puedes redirigir a una página de error personalizada si la modificación falla
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            response.sendRedirect("error.jsp");
        }
    }
}
