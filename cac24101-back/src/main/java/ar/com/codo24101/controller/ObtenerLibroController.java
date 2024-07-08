package ar.com.codo24101.controller;

import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.service.LibroService;

public class ObtenerLibroController {

    public static void main(String[] args) {
        
        Long id = 1L;

        LibroService service = new LibroService();

        Libro libro = service.obtener(id);

            System.out.println(libro);
    }
}
