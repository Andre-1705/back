package ar.com.codo24101.dao;

import java.util.ArrayList;

import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.dto.LibroDto;

public interface LibroDao {

    public Libro getById(Long l);

    public void create(LibroDto libroDto);

    public ArrayList<Libro> findAll();

    public void update(Libro libro);

    public void eliminar(Libro libroAEliminar);
}
