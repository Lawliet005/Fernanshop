package modelos;

public class Administrador {
    public final static String perfil = "ADMINISTRADOR";

    private String id;
    private String nombre;
    private String correo;
    private String contrasenia;

    public Administrador(String nombre, String correo, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id='" + id + '\'' +
                "nombre='" + nombre + '\'' +
                "correo='" + correo + '\'' +
                "contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
