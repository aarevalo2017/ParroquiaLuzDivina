package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandra Coello
 */
public class Conexion {
   public static Conexion instancia; // Nos servira para utilizar el singleton.
    private Connection connection; // Nos sirve para conectarse a la BD.

    // Cambiar a privado
    private Conexion() {
        try {
            //Servidor - la conexion - propiedades.
            Class.forName("com.mysql.jdbc.Driver"); // Driver class o Controlador
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/parroquia?zeroDateTimeBehavior=convertToNull","root",""); // URL de la BD, USER, PASS
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Singleton, synchronized: nos crea una lista de espera haciendo que entre de uno en uno.
    // Para crear una conexion a la BD, tenemos que llamar a este metodo.
    public synchronized static Conexion estado() {
        if ( instancia == null ) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void cerrarConexion() {
        instancia = null;
    } 
}
