package ar.com.codo24101.controller;

import java.io.IOException;

import ar.com.codo24101.service.LibroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EliminarLibroController")
public class EliminarLibroController extends HttpServlet{

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        LibroService service = new LibroService();

        Long idLong = Long.parseLong(id);

        service.eliminar(idLong);

        resp.setStatus(HttpServletResponse.SC_OK);
    }   
}