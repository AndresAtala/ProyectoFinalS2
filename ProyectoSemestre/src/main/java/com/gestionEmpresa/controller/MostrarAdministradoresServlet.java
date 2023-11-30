package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Administrador;
import com.gestionEmpresa.model.data.DAO.AdministradorDAO;
import com.gestionEmpresa.model.data.DBGenerator;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MostrarAdministradores")
public class MostrarAdministradoresServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener el contexto DSL
            DSLContext create = DBGenerator.conectarBD("Proyecto");

            // Crear instancia de AdministradorDAO fuera del bloque try
            AdministradorDAO administradorDAO = new AdministradorDAO(create);

            // Obtener la lista de administradores
            List<Administrador> administradores = administradorDAO.obtenerTodosAdministradores();

            // Imprimir la lista de administradores en la consola del servidor
            System.out.println("Lista de Administradores:");
            for (Administrador admin : administradores) {
                System.out.println(admin);
            }

            // Agregar la lista de administradores al objeto request con el nombre correcto
            request.setAttribute("administradores", administradores);

            // Enviar la solicitud al JSP para mostrar la lista
            request.getRequestDispatcher("/mostrarAdministradores.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}