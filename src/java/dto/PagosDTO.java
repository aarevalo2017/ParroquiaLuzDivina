/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author Alejandra Coello
 */
public class PagosDTO {    
    private int monto;
    private String estado;
    private Date fecha;
    private String tipoRecaudador;
    private String motivo;

    public PagosDTO() {
    }
    public PagosDTO(int monto, String estado, Date fecha, String tipoRecaudador, String motivo) {
        this.monto = monto;
        this.estado = estado;
        this.fecha = fecha;
        this.tipoRecaudador = tipoRecaudador;
        this.motivo = motivo;
    }

    public PagosDTO(int monto, String estado, java.util.Date fecha, String motivo, String tipoRecaudador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoRecaudador(String tipoRecaudador) {
        this.tipoRecaudador = tipoRecaudador;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipoRecaudador() {
        return tipoRecaudador;
    }

    public String getMotivo() {
        return motivo;
    }
    
}
