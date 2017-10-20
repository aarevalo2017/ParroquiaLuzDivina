package dao;

import conexion.Conexion;
import dto.PagosDTO;
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
public class PagosDAO {
    // Paso 1: implementar los metodos los metodos abstracotos de la interface.
    // Paso 2: declarar los QUERYS para el CRUD.
    // Paso 3: Agregar la Conexion.
    
    //QUERYS
    private static final String SQL_INSERT = "INSERT INTO pagos (monto,estado,fecha,tipoRecaudador,motivo) VALUES (?, ? ,?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pagos SET monto = ?, estado = ?, fecha = ?, motivo = ?, WHERE tipoRecaudador = ?";
    private static final String SQL_DELETE = "DELETE FROM pagos WHERE tipoRecaudador = ?";
    private static final String SQL_READ = "SELECT * FROM pagos WHERE tipoRecaudador = ?";
    private static final String SQL_READALL = "SELECT * FROM pagos";
    // Aplicamos el Singleton.
    // Tengo que preguntar si existe o no la conexion.
    private static final Conexion conexion = Conexion.estado(); 
    
    public boolean create(PagosDTO pago) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, pago.getMonto());
            preparedStatement.setString(2, pago.getEstado());
            preparedStatement.setDate(3, pago.getFecha());
            preparedStatement.setString(4, pago.getTipoRecaudador());
            preparedStatement.setString(5, pago.getMotivo());
            
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

    public boolean update(PagosDTO pago) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE);
            preparedStatement.setInt(1, pago.getMonto());
            preparedStatement.setString(2, pago.getEstado());
            preparedStatement.setDate(3, pago.getFecha());
            preparedStatement.setString(4, pago.getTipoRecaudador());
            preparedStatement.setString(5, pago.getMotivo());
            
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

    public PagosDTO read(Object pk) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        PagosDTO pagosDTO = null;
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            preparedStatement.setString(1, pk.toString());
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar el evento indicado
            while ( resultSet.next() ) {
                pagosDTO = new PagosDTO(resultSet.getInt("monto"),resultSet.getString("estado"),resultSet.getDate("fecha"),resultSet.getString("motivo"),resultSet.getString("tipoRecaudador"));
            }
           return pagosDTO;
            
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return pagosDTO;
    }

    public List<PagosDTO> readAll() {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        ArrayList<PagosDTO> pagos = new ArrayList<>();
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READALL);
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar los datos y guardarlos en el arraylist
            while ( resultSet.next() ) {
                pagos.add(new PagosDTO(resultSet.getInt("monto"),resultSet.getString("estado"),resultSet.getDate("fecha"),resultSet.getString("motivo"),resultSet.getString("tipoRecaudador")));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EventosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return pagos;
    }
    
}
