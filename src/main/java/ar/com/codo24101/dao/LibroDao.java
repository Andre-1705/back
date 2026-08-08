package ar.com.codo24101.dao;

import java.util.ArrayList;
import ar.com.codo24101.domain.Libro;

public interface LibroDao {

    public Libro getById(Long id);

    public void create(Libro libro);

    public ArrayList<Libro> findAll();

    public void update(Libro libro);

    public void eliminar(Libro libroAEliminar);
}