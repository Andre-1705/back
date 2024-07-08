package ar.com.codo24101.controller;

import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.dto.LibroDto;
import ar.com.codo24101.service.LibroService;

public class ActualizarLibroController {


    public static void main(String[] args) {
        LibroService service = new LibroService();

        Libro libro = service.listarLibro().get(0);
        
        System.out.println("original");
        System.out.println(libro);

        libro.setTitulo("nuevo titulo");
        libro.setAutor("nuevo autor");

        LibroDto libroToUpdateDto = new LibroDto(
            libro.getId(),
            libro.getTitulo(),
            libro.getAutor(),
            libro.getPrecio(),
            libro.getImg(),
            libro.getIsbn());

        libro.setTitulo("nuevo titulo");
        service.actualizar(libroToUpdateDto);

        Libro actualizado = service.obtener(libro.getId());
        System.out.println(actualizado);
    }
}
