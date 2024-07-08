package ar.com.codo24101.domain;

import java.util.ArrayList;

import ar.com.codo24101.dao.LibroJdbcMysqlImpl;

public class MainBuscador {

    public static void main(String[] args) {
        String claveEnviadaPorElUsuarioEnElForm = "Ciudadela";
        Buscador b = new Buscador();
        b.setClave(claveEnviadaPorElUsuarioEnElForm);
        b.buscar();
        b.mostrarResultados();

        //libro

        LibroJdbcMysqlImpl libroDao = new LibroJdbcMysqlImpl();

        //libro por su ID

        Long libroId = 1L;
        Libro libro = libroDao.getById(libroId);
        System.out.println("Libro encontrado por ID " + libroId + ": " + libro);

        //Crear un nuevo libro

        Libro nuevoLibro = new Libro(1L, "titulo1", "autor1", 100000L, "https:/bla/bla", "IALA12345456"); 
        libroDao.create(nuevoLibro);
        System.out.println("Nuevo libro creado: " + nuevoLibro);

        //Obtener todos los libros

        ArrayList<Libro> listaDeLibro = libroDao.findAll();
        String sql = "SELECT * FROM Libro";
        System.out.println("Lista de libro: " + listaDeLibro);

        //Actualizar un libro existente

        Libro libroActualizado = new Libro(1L, "titulo2", "autor2", 200000L, "htps:/ble/ble", "IACCR123455678"); 
        libroDao.update(libroActualizado);
        System.out.println("Libro actualizado: " + libroActualizado);    
    }
}
