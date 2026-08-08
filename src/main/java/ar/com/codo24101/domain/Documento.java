package ar.com.codo24101.domain;

public class Documento extends Articulo{

    public Documento(String titulo, String autor, Long precio, String img) {
        super(titulo, autor, precio, img);

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
