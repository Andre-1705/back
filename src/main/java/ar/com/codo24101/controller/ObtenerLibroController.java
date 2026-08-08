package ar.com.codo24101.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.service.LibroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ObtenerLibroController")
public class ObtenerLibroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        Long id = Long.parseLong(idParam);

        LibroService service = new LibroService();
        Libro libro = service.obtener(id);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(new ObjectMapper().writeValueAsString(libro));
    }
}