package dto;

/**
 *
 * @author Alejandra Coello
 */
public class ComunidadesDTO {
    private String nombre;
    private String direccion;
    private String telefono;

    public ComunidadesDTO() {
    }

    public ComunidadesDTO(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
