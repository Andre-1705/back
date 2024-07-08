package ar.com.codo24101.domain;

public class Libro extends Articulo {

    private Long id;
    private String isbn;

    public Libro(Long id, String titulo, String autor, Long precio, String img, String isbn) {
        super(titulo, autor, precio, img);
        this.isbn = isbn;
    }

    public Libro(String titulo, String autor, Long precio, String img, String isbn){
        super(titulo, autor, precio, img);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + ", Libro: [isbn=" + isbn + "]";
    } 
}
