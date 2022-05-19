//En este java class estara la conexion  con la base de datos
package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Connection con=null;
    private static final String URL="jdbc:mysql://localhost:3306/ejemplo001";//driver, url y nombre de la base de datos a conectar
    private static final String USER="root";
    private static final String PASS="";
    public static Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception e) {
            System.err.println("Error:"+e); // captura el error de conexion
        }
        return con; //me devuelve la variable con los datos de conexion a la base
    }
}
