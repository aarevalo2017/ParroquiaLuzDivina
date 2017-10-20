package dao;

import conexion.Conexion;
import dto.ErogantesDTO;
import java.sql.Date;
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
public class ErogantesDAO {
    // Paso 1: implementar los metodos los metodos abstracotos de la interface.
    // Paso 2: declarar los QUERYS para el CRUD.
    // Paso 3: Agregar la Conexion.
    
    //QUERYS
    private static final String SQL_INSERT = "INSERT INTO erogantes (rut,nombre,fNac,telefono,direccion,mail,estado,tipoErogante) VALUES (?, ? ,?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE erogantes SET nombre = ?, fNac = ?, telefono = ?, direccion = ?, mail = ?, estado = ?, tipoErogante = ? WHERE rut = ?";
    private static final String SQL_DELETE = "DELETE FROM erogantes WHERE rut = ?";
    private static final String SQL_READ = "SELECT * FROM erogantes WHERE rut = ?";
    private static final String SQL_READALL = "SELECT * FROM erogantes";
    // Aplicamos el Singleton.
    // Tengo que preguntar si existe o no la conexion.
    private static final Conexion conexion = Conexion.estado(); 
    
    public boolean create(ErogantesDTO erogante) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, erogante.getRut());
            preparedStatement.setString(2, erogante.getNombre());
            preparedStatement.setDate(3, erogante.getfNac());
            preparedStatement.setString(4, erogante.getTelefono());
            preparedStatement.setString(5, erogante.getDireccion());
            preparedStatement.setString(6, erogante.getMail());
            preparedStatement.setString(7, erogante.getEstado());
            preparedStatement.setString(8, erogante.getTipoErogante());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ErogantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public boolean update(ErogantesDTO erogante) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, erogante.getRut());
            preparedStatement.setString(2, erogante.getNombre());
            preparedStatement.setDate(3, erogante.getfNac());
            preparedStatement.setString(4, erogante.getTelefono());
            preparedStatement.setString(5, erogante.getDireccion());
            preparedStatement.setString(6, erogante.getMail());
            preparedStatement.setString(7, erogante.getEstado());
            preparedStatement.setString(8, erogante.getTipoErogante());
            
            // Nos retorna un 1 cuando se ejecuta correctamente.
            // Nos retorna un 0 cuando no se ejecuta correctamente.
            if ( preparedStatement.executeUpdate() > 0 ) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ErogantesDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ErogantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return false;
    }

    public ErogantesDTO read(Object pk) {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        ErogantesDTO erogantesDTO = null;
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READ);
            preparedStatement.setString(1, pk.toString());
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar el erogante indicado
            while ( resultSet.next() ) {
                erogantesDTO = new ErogantesDTO(resultSet.getString("rut"),resultSet.getString("nombre"),resultSet.getDate("fNac"),resultSet.getString("telefono"),resultSet.getString("direccion"),resultSet.getString("mail"),resultSet.getString("estado"),resultSet.getString("tipoErogante"));
            }
           return erogantesDTO;
            
        } catch (SQLException ex) {
            Logger.getLogger(ErogantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return erogantesDTO;
    }

    public List<ErogantesDTO> readAll() {
        // Preparamos el statement para ejecutar nuestro query.
        PreparedStatement preparedStatement;
        // Almacenamos en el resultset todo el SELECT
        ResultSet resultSet;
        ArrayList<ErogantesDTO> erogantes = new ArrayList<>();
        
        try {
            // Indicamos al statement cual query tiene que utilizar.
            preparedStatement = conexion.getConnection().prepareStatement(SQL_READALL);
            // Ejecutamos el QUERY y guardamos el resultado en el resultset
            resultSet = preparedStatement.executeQuery();
            
            // Recorremos el resulset para sacar los datos y guardarlos en el arraylist
            while ( resultSet.next() ) {
                erogantes.add(new ErogantesDTO(resultSet.getString("rut"),resultSet.getString("nombre"),resultSet.getDate("fNac"),resultSet.getString("telefono"),resultSet.getString("direccion"),resultSet.getString("mail"),resultSet.getString("estado"),resultSet.getString("tipoErogante")));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ErogantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return erogantes;
    }
}
