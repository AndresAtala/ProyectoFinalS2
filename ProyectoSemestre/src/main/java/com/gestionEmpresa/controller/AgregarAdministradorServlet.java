package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Administrador;
import com.gestionEmpresa.model.data.DAO.AdministradorDAO;
import com.gestionEmpresa.model.data.DBGenerator;
import org.jooq.DSLContext;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AgregarAdministradorServlet")
public class AgregarAdministradorServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher respuesta = req.getRequestDispatcher("/index.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String rut = req.getParameter("rut");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String rol = req.getParameter("rol");

            Administrador admin = new Administrador(nombre, apellido, rut, telefono, rol);

            DSLContext query = DBGenerator.conectarBD("Proyecto");
            AdministradorDAO adminDAO = new AdministradorDAO(query);
            adminDAO.agregarAdministrador(admin);
            resp.sendRedirect("index.jsp");

        } catch (NumberFormatException e) {

            e.printStackTrace();
            resp.sendRedirect("index.jsp");
        } catch (Exception e) {

            e.printStackTrace();
            resp.sendRedirect("index.jsp");
        }
    }
}

