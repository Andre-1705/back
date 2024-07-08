package ar.com.codo24101.service;

import java.util.ArrayList;

import ar.com.codo24101.dao.LibroDao;
import ar.com.codo24101.dao.LibroJdbcMysqlImpl;
import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.dto.LibroDto;;

public class LibroService {

    private LibroDao dao;

    public LibroService(){
        this.dao = new LibroJdbcMysqlImpl();
    }
    
    public Libro obtener(Long l){
        return this.dao.getById(l);
    }

    public void crear(LibroDto dto){
        Libro l = new Libro(dto.getId(), dto.getTitulo(), dto.getAutor(), dto.getPrecio(), dto.getImg(), dto.getIsbn());
        this.dao.create(dto);
    }

    public ArrayList<Libro> listarLibro() {
        return this.dao.findAll();
    }

    public void actualizar(LibroDto dto){
        Libro libro = new Libro(
            dto.getId(),
            dto.getTitulo(),
            dto.getAutor(),
            dto.getPrecio(),
            dto.getImg(),
            dto.getIsbn());

        this.dao.update(libro);    
    }

    public void eliminar(Long id) {
        
        Libro libroAEliminar = (Libro) this.dao.getById(id);
        
        this.dao.eliminar(libroAEliminar);
            
        System.out.println("Libro eliminado correctamente.");
    }
    //listar libros()
}
