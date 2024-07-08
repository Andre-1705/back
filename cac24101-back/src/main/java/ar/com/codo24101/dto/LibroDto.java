package ar.com.codo24101.dto;

public class LibroDto {
    private Long Id;
    private String titulo;
    private String autor;
    private Long precio;
    private String img;
    private String isbn;

    
    public LibroDto(Long id, String titulo, String autor, Long precio, String img, String isbn) {
        this.Id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.img = img;
        this.isbn = isbn;
    }

    public LibroDto(String titulo, String autor, Long precio, String img, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.img = img;
        this.isbn = isbn;
    }

    public LibroDto() {

    }

    @Override
    public String toString() {
        return "LibroDto [titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", img=" + img + ", isbn=" + isbn + "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
