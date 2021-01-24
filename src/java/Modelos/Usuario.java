package Modelos;

import java.io.Serializable;

/**
 *
 * @author javy
 */
public abstract class Usuario implements Serializable {
    
    private String user;
    private String pass;
    private String rol;
    private String Nombre;
    private String Vista;

    public Usuario(String user, String pass, String rol, String Nombre) {
        this.user = user;
        this.pass = pass;
        this.rol = rol;
        this.Nombre = Nombre;
    }

    

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public abstract String getVista();   
}
