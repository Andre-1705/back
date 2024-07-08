package ar.com.codo24101.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.service.LibroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ListarLibroController")

public class ListarLibroController extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
    
        LibroService service = new LibroService();

        ArrayList<Libro> listado = service.listarLibro();

        ObjectMapper mapper = new ObjectMapper();

		String libroJSON = mapper.writeValueAsString(listado);
        
        resp.getWriter().println(libroJSON);

    }
}