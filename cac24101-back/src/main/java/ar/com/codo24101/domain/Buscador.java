package ar.com.codo24101.domain;

import java.util.ArrayList;

public class Buscador {

    private String claveDeBusqueda;
    private ArrayList<Articulo> resultados;

    public Buscador() {
        this.resultados = new ArrayList<>();
    }

    public int getCantidad() {
        return this.resultados.size();
    } 

    public void setClave(String clave){

        if(clave == null) {
            this.claveDeBusqueda = "";

        }else {
            this.claveDeBusqueda = clave;
        }
    }

    public void buscar() {
        
        Libro art = new Libro(claveDeBusqueda, "Antoine de Saint Exùpery", 88000L, "http://bla.com.ar/img/bla.jpg", "IALA1234654");
        resultados.add(art);

        Documento d = new Documento(claveDeBusqueda, "Desconocido", 6600000L, "http://ble.com/img/ble.jpg");
        resultados.add(d);
    }

    public void mostrarResultados() {

        System.out.println("Hemos Encontrado "+ getCantidad() + " Resultados Para 'Ciudadela'");

        for(Articulo art : resultados) {
            
            System.out.println(art.toString());
        }
    }
}
