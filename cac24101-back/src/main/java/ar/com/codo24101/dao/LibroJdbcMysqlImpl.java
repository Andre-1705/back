package ar.com.codo24101.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.domain.Libro;
import ar.com.codo24101.dto.LibroDto;
import ar.com.codo24101.service.LibroService;

public class LibroJdbcMysqlImpl implements LibroDao{

    @Override
    public Libro getById(Long id) {
        String sql = "SELECT * FROM libro WHERE id =?"+ id;

        Libro libro = null;
        Connection connection = null;
        
        try{
            connection = AdministradorConnexiones.connectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, id); 

            ResultSet resultset = statement.executeQuery();

            if(resultset.next()) {

                Long Id = resultset.getLong(1);
                String titulo = resultset.getString(2);
                String autor = resultset.getString(3);
                Long precio = resultset.getLong(4);
                String img = resultset.getString(5);
                String Isbn = resultset.getString(6);

                libro = new Libro(Id, titulo, autor, precio, img, Isbn);
            }

        }catch(Exception e) {
            System.err.println(e);

        } finally {
            
            AdministradorConnexiones.desconectar(connection);
        }
        return libro;
    }

    public void create(Libro libroDto) {

        String sql = "INSERT INTO libro (titulo, autor, precio, img, isbn) values(?,?,?,?,?)";
        Connection connection = AdministradorConnexiones.connectar();
       
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, libroDto.getTitulo());
            ps.setString(2, libroDto.getAutor());
            ps.setLong(3, libroDto.getPrecio());
            ps.setString(4, libroDto.getImg());
            ps.setString(5, libroDto.getIsbn());

            ps.executeUpdate();

            if(ps.getUpdateCount() > 0) {

                System.out.println("Insert ok");
            }
        }catch(Exception e) {
            e.printStackTrace();

        }finally {
            AdministradorConnexiones.desconectar(connection);
        }        
    }

    @Override
    public ArrayList<Libro> findAll() {

        String sql = "SELECT * FROM libro"; 

        ArrayList<Libro> listaDeLibro = new ArrayList<>();
        Connection connection = null;

        try{
            
            connection = AdministradorConnexiones.connectar();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()) {

                Long Id = resultset.getLong(1);
                String titulo = resultset.getString(2);
                String autor= resultset.getString(3);
                Long precio = resultset.getLong(4);
                String img = resultset.getString(5);
                String Isbn = resultset.getString(6);

                Libro unLibro = new Libro(Id, titulo, autor, precio, img, Isbn);
                listaDeLibro.add(unLibro);
            }

        }catch(Exception e) {
            System.err.println(e);

        } finally {
            
            AdministradorConnexiones.desconectar(connection);
        }

        return listaDeLibro;
    }

    @Override
    public void update(Libro libro) {          

        String sql = "UPDATE libro set titulo=?, autor=?, precio=?, img=?, isbn=? WHERE id=?";

        Connection connection = AdministradorConnexiones.connectar();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setLong(3, libro.getPrecio());
            ps.setString(4, libro.getImg());
            ps.setString(5, libro.getIsbn());

            ps.setLong(6, libro.getId());

            ps.executeUpdate();

            if(ps.getUpdateCount() > 0) {
                System.out.println("update ok");
            }

        }catch(Exception e) {
            e.printStackTrace();

        }finally {
            AdministradorConnexiones.desconectar(connection);
        }    
    }

    @Override
    public void eliminar(Libro libroAEliminar) {

        String sql = "DELETE FROM libro where id = ?";

        Connection connection = AdministradorConnexiones.connectar();

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setLong(1, libroAEliminar.getId());

            ps.executeUpdate();

            if(ps.getUpdateCount() == 0) {
                throw new RuntimeException("No se pudo eliminar el registro");
            }

        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }finally {
            AdministradorConnexiones.desconectar(connection);
        } 
    }

    @Override
    public void create(LibroDto libroDto) {
       
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    public static void main(String[] args) {

        try {            
            LibroJdbcMysqlImpl libroDao = new LibroJdbcMysqlImpl();

            Long Id = 1L;
            Libro libro = libroDao.getById(Id);
            System.out.println("Libro encontrado por ID " + Id + ": " + libro);

        } catch (Exception e) {
            e.printStackTrace();
        }      
/*     
        try {
            LibroJdbcMysqlImpl libroDao = new LibroJdbcMysqlImpl();

            Libro nuevoLibro = new Libro(null, null, null, null, null, null);
            nuevoLibro.setTitulo("El Gran Gatsby");
            nuevoLibro.setAutor("F. Scott Fitzgerald");
            nuevoLibro.setPrecio(25000L);
            nuevoLibro.setImg("ruta/imagen.jpg");
            nuevoLibro.setIsbn("9781234567890");

    
            libroDao.create(nuevoLibro);

            System.out.println("Libro insertado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
*/    

        LibroDao libroDao = new LibroJdbcMysqlImpl();
        ArrayList<Libro> listaLibro = libroDao.findAll();

        Long idBuscado = 1L;

        for (Libro libro : listaLibro) {
            if(libro.getId() == idBuscado)
            System.out.println(listaLibro); 
        }

        LibroService service = new LibroService();
        ArrayList<Libro> listado = service.listarLibro();
        ObjectMapper mapper = new ObjectMapper();

        try {
            
            String libroJSON = mapper.writeValueAsString(listado);
            System.out.println("Listado de libro en formato JSON: ");
            System.out.println(libroJSON);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Libro> listaDeLibro = libroDao.findAll();
        String sql = "SELECT * FROM Libro";
        System.out.println("Lista de libro: " + listaDeLibro);
    }
}    