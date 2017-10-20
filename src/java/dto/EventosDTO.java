package dto;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alejandra Coello
 */
public class EventosDTO {
    private Date fecha;
    private Time hora;
    private String tipoEvento;

    public EventosDTO() {
    }

    public EventosDTO(Date fecha, Time hora, String tipoEvento) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipoEvento = tipoEvento;
    }

    public EventosDTO(java.util.Date fecha, Time hora, String tipoEvento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EventosDTO(java.util.Date fecha, SimpleDateFormat hora, String tipoEvento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }
    
    
    
}
