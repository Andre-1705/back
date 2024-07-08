package ar.com.codo24101.controller;
import java.io.IOException;
import java.util.stream.Collectors;
import ar.com.codo24101.dto.LibroDto;
import ar.com.codo24101.service.LibroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/ModificarLibroController")
public class ModificarLibroController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json = req.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));
            
        ObjectMapper mapper = new ObjectMapper();

        LibroDto libroDto = mapper.readValue(json, LibroDto.class);

        LibroService service = new LibroService();

        System.out.println(libroDto);

        service.actualizar(libroDto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}

