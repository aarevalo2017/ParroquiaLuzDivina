package dao;

import conexion.Conexion;
import dto.EventosDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandra Coello
 */
public class EventosDAO {
    // Paso 1: implementar los metodos los metodos abstracotos de la interface.
    // Paso 2: declarar los QUERYS para el CRUD.
    // Paso 3: Agregar la Conexion.
    
    //QUERYS
    private static final String SQL_INSERT = "INSERT INTO eventos (fecha,hora,tipoEvento) VALUES (?, ? ,?)";
    private static final String SQL_UPDATE = "UPDATE eventos SET fecha = ?, hora = ? WHERE tipoEvento = ?";
    private static final String SQL_DELETE = "DELETE FROM eventos WHERE tipoEvento = ?";
    private static final String SQL_READ = "SELECT * FROM eventos WHERE tipoEvento = ?";
    private static final String SQL_READALL = "SELECT * FROM eventos";
    // Aplicamos el Singleton.
    // Tengo que preguntar si existe o no la conexion.
    private static final Conexion conexion = Conexion.estado(); 
    
    public boolean create(EventosDTO evento) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setDate(1, evento.getFecha());
            preparedStatement.setTime(2, evento.getHora());
            preparedStatement.setString(3, evento.getTipoEvento());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean update(EventosDTO evento) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE);
            preparedStatement.setDate(1, evento.getFecha());
            preparedStatement.setTime(2, evento.getHora());
            preparedStatement.setString(3, evento.getTipoEvento());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean delete(Object pk) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, pk.toString());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public EventosDTO read(Object pk) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        EventosDTO eventosDTO = null;
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            preparedStatement.setString(1, pk.toString());
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar el evento indicado
            while ( resultSet.next() ) {
                eventosDTO = new EventosDTO(resultSet.getDate("fecha"),resultSet.getTime("hora"),resultSet.getString("tipoEvento"));
            }
           return eventosDTO;
            
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return eventosDTO;
    }

    public List<EventosDTO> readAll() {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        ArrayList<EventosDTO> eventos = new ArrayList<>();
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READALL);
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar los datos y guardarlos en el arraylist
            while ( resultSet.next() ) {
                eventos.add(new EventosDTO(resultSet.getDate("fecha"),resultSet.getTime("hora"),resultSet.getString("tipoEvento")));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return eventos;
    }
}
