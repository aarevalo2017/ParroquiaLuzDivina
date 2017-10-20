package dao;

import conexion.Conexion;
import dto.UsuarioDTO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author Alejandra Coello
 */
public class UsuarioDAO {
    // Paso 1: implementar los metodos los metodos abstracotos de la interface.
    // Paso 2: declarar los QUERYS para el CRUD.
    // Paso 3: Agregar la Conexion.
    
    //QUERYS
    private static final String SQL_READ = "SELECT user, pass, tipo_usuario FROM usuarios WHERE user = ? AND pass = ? ";
    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class);

    // Aplicamos el Singleton.
    // Tengo que preguntar si existe o no la conexion.
    private static final Conexion conexion = Conexion.estado(); 

    public UsuarioDAO() {
        try {
            LOG.addAppender(new FileAppender( new PatternLayout(),"D:\\LogLuz_Divina.txt",true));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UsuarioDTO read(UsuarioDTO usuario) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        UsuarioDTO usuarioDTO = null;
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            preparedStatement.setString(1, usuario.getUser());
            preparedStatement.setString(2, usuario.getPass());
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar el alumno indicado
            while ( resultSet.next() ) {
                usuarioDTO = new UsuarioDTO(resultSet.getString("user"),resultSet.getString("pass"),resultSet.getInt("tipo_usuario"));
                return usuarioDTO;
            }
            
        } catch (SQLException ex) {
            LOG.error("ERROR en UsuarioDAO.read : " + ex.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return usuarioDTO;
    }
}
