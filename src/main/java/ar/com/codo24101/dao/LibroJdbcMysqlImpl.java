package ar.com.codo24101.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ar.com.codo24101.domain.Libro;

public class LibroJdbcMysqlImpl implements LibroDao {

    @Override
    public Libro getById(Long id) {
        String sql = "SELECT * FROM libro WHERE id = ?";

        Libro libro = null;
        Connection connection = null;

        try {
            connection = AdministradorConnexiones.connectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultset = statement.executeQuery();

            if (resultset.next()) {
                Long Id = resultset.getLong(1);
                String titulo = resultset.getString(2);
                String autor = resultset.getString(3);
                Long precio = resultset.getLong(4);
                String img = resultset.getString(5);
                String isbn = resultset.getString(6);
                libro = new Libro(Id, titulo, autor, precio, img, isbn);
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorConnexiones.desconectar(connection);
        }
        return libro;
    }

    @Override
    public void create(Libro libro) {
        String sql = "INSERT INTO libro (titulo, autor, precio, img, isbn) VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;

        try {
            connection = AdministradorConnexiones.connectar();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setLong(3, libro.getPrecio());
            ps.setString(4, libro.getImg());
            ps.setString(5, libro.getIsbn());
            ps.executeUpdate();
            System.out.println("Insert ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorConnexiones.desconectar(connection);
        }
    }

    @Override
    public ArrayList<Libro> findAll() {
        String sql = "SELECT * FROM libro";
        ArrayList<Libro> lista = new ArrayList<>();
        Connection connection = null;

        try {
            connection = AdministradorConnexiones.connectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Long id = resultset.getLong(1);
                String titulo = resultset.getString(2);
                String autor = resultset.getString(3);
                Long precio = resultset.getLong(4);
                String img = resultset.getString(5);
                String isbn = resultset.getString(6);
                lista.add(new Libro(id, titulo, autor, precio, img, isbn));
            }

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            AdministradorConnexiones.desconectar(connection);
        }
        return lista;
    }

    @Override
    public void update(Libro libro) {
        String sql = "UPDATE libro SET titulo=?, autor=?, precio=?, img=?, isbn=? WHERE id=?";
        Connection connection = null;

        try {
            connection = AdministradorConnexiones.connectar();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setLong(3, libro.getPrecio());
            ps.setString(4, libro.getImg());
            ps.setString(5, libro.getIsbn());
            ps.setLong(6, libro.getId());
            ps.executeUpdate();
            System.out.println("Update ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorConnexiones.desconectar(connection);
        }
    }

    @Override
    public void eliminar(Libro libroAEliminar) {
        String sql = "DELETE FROM libro WHERE id = ?";
        Connection connection = null;

        try {
            connection = AdministradorConnexiones.connectar();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, libroAEliminar.getId());
            ps.executeUpdate();
            System.out.println("Delete ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AdministradorConnexiones.desconectar(connection);
        }
    }
}