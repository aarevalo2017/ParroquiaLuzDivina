package dto;

/**
 *
 * @author Alejandra Coello
 */
public class UsuarioDTO {
    private String user;
    private String pass;
    private int tipo_usuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String user, String pass, int tipo_usuario) {
        this.user = user;
        this.pass = pass;
        this.tipo_usuario = tipo_usuario;
    }

    public UsuarioDTO(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
}
