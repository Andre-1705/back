package ar.com.codo24101.dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class AdministradorConnexiones {

    public static Connection connectar(){

        String url = "jdbc:mysql://localhost:3306/libro?serverTimeZone=UTC&usserSSL=false";
        String user = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";

        Connection conn = null;

        try{
            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, password);

        }catch(Exception e){
            System.err.println(e);

        }
            return conn;
    }

    public static void desconectar(Connection connection){

        try{
            connection.close();

        }catch(Exception e){
            System.err.println(e);
        }
    }
}
