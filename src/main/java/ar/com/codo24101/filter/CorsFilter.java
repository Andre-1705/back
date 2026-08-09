package ar.com.codo24101.filter;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"})
public class CorsFilter implements Filter {

    private final List<String> origins = List.of(
        "http://localhost:5500",
        "http://127.0.0.1:5500",
        "http://localhost:3000",
        "http://127.0.0.1:5501"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String origin = ((HttpServletRequest) request).getHeader("origin");

        if (origin != null && origins.contains(origin)) {
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.addHeader("Access-Control-Allow-Origin", origin);
            resp.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
        }

        chain.doFilter(request, response);
    }
}
