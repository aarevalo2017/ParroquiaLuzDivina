package dto;

import java.sql.Date;

/**
 *
 * @author Alejandra Coello
 */
public class ErogantesDTO {
    private String rut;
    private String nombre;
    private Date fNac;
    private String telefono;
    private String direccion;
    private String mail;
    private String estado;
    private String tipoErogante;

    public ErogantesDTO() {
    }

    public ErogantesDTO(String rut, String nombre, Date fNac, String telefono, String direccion, String mail, String estado, String tipoErogante) {
        this.rut = rut;
        this.nombre = nombre;
        this.fNac = fNac;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mail = mail;
        this.estado = estado;
        this.tipoErogante = tipoErogante;
    }

    public ErogantesDTO(String rut, String nombre, java.util.Date fNac, String telefono, String direccion, String mail, String estado, String tipoErogante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipoErogante(String tipoErogante) {
        this.tipoErogante = tipoErogante;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getfNac() {
        return fNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getMail() {
        return mail;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoErogante() {
        return tipoErogante;
    }

       
}
