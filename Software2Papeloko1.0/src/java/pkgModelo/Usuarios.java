package pkgModelo;



/**
 * Generated 13-mar-2017 7:55:58 by Hibernate Tools 4.3.1
 * EDUARD
 */
public class Usuarios  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String apellido;
     private String rol;
     private String credenciales;

    public Usuarios() {
    }

	
    public Usuarios(int id) {
        this.id = id;
    }
    public Usuarios(int id, String nombre, String apellido, String rol, String credenciales) {
       this.id = id;
       this.nombre = nombre;
       this.apellido = apellido;
       this.rol = rol;
       this.credenciales = credenciales;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getCredenciales() {
        return this.credenciales;
    }
    
    public void setCredenciales(String credenciales) {
        this.credenciales = credenciales;
    }




}


