package dao;

import conexion.Conexion;
import dto.ComunidadesDTO;
import interfaces.Metodos;
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
public class ComunidadesDAO implements Metodos<ComunidadesDTO>{
    // Paso 1: implementar los metodos los metodos abstracotos de la interface.
    // Paso 2: declarar los QUERYS para el CRUD.
    // Paso 3: Agregar la Conexion.
    
    //QUERYS
    private static final String SQL_INSERT = "INSERT INTO comunidades (nombre,direccion,telefono) VALUES (?, ? ,?)";
    private static final String SQL_UPDATE = "UPDATE comunidades SET direccion = ?, telefonno = ? WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM comunidades WHERE nombre = ?";
    private static final String SQL_READ = "SELECT * FROM comunidades WHERE nombre = ?";
    private static final String SQL_READALL = "SELECT * FROM comunidades";
    // Aplicamos el Singleton.
    // Tengo que preguntar si existe o no la conexion.
    private static final Conexion conexion = Conexion.estado(); 
    
    @Override
    public boolean create(ComunidadesDTO comunidad) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, comunidad.getDireccion());
            preparedStatement.setString(2, comunidad.getTelefono());
            preparedStatement.setString(3, comunidad.getNombre());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComunidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ComunidadesDTO comunidad) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, comunidad.getDireccion());
            preparedStatement.setString(2, comunidad.getTelefono());
            preparedStatement.setString(3, comunidad.getNombre());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComunidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
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
            Logger.getLogger(ComunidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    @Override
    public ComunidadesDTO read(Object pk) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        ComunidadesDTO comunidadesDTO = null;
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            preparedStatement.setString(1, pk.toString());
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar la comunidad indicada
            while ( resultSet.next() ) {
                comunidadesDTO = new ComunidadesDTO(resultSet.getString("nombre"),resultSet.getString("direccion"),resultSet.getString("telefono"));
            }
           return comunidadesDTO;
            
        } catch (SQLException ex) {
            Logger.getLogger(ComunidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return comunidadesDTO;
    }

    @Override
    public List<ComunidadesDTO> readAll() {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        ArrayList<ComunidadesDTO> comunidades = new ArrayList<>();
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READALL);
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar los datos y guardarlos en el arraylist
            while ( resultSet.next() ) {
                comunidades.add(new ComunidadesDTO(resultSet.getString("nombre"),resultSet.getString("direccion"),resultSet.getString("telefono")));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ComunidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return comunidades;
    }
}
