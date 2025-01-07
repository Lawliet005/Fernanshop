package modelos;

public class Trabajador {
    public final static String perfil = "TRABAJADOR";

    private String id;
    private String nombre;
    private String correo;
    private String contrasenia;

    private  Pedido pedidoAsignado1;
    private  Pedido pedidoAsignado2;

    public Trabajador(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public Trabajador (String nombre){
        this.nombre = nombre;
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

    public Pedido getPedidoAsignado1() {
        return pedidoAsignado1;
    }

    public void setPedidoAsignado1(Pedido pedidoAsignado1) {
        this.pedidoAsignado1 = pedidoAsignado1;
    }

    public Pedido getPedidoAsignado2() {
        return pedidoAsignado2;
    }

    public void setPedidoAsignado2(Pedido pedidoAsignado2) {
        this.pedidoAsignado2 = pedidoAsignado2;
    }


    public void asignarPedido(Pedido pedidoasignar){
        if(pedidoAsignado1 == null){
            pedidoAsignado1 = pedidoasignar;
            System.out.println("Pedido "+pedidoasignar.getCodigo()+" asignado al trabajador "+this.nombre);
        } else if (pedidoAsignado2 == null) {
            pedidoAsignado2 = pedidoasignar;
            System.out.println("Pedido "+pedidoasignar.getCodigo()+" asignado al trabajador "+this.nombre);
        }else{
            System.out.println("El trabajador ya tiene dos pedidos asignados");
        }
    }

    public int contarPedidosAsignados(){
        int pedidosAsignados = 0;
        if(pedidoAsignado1 != null){
            pedidosAsignados++;
        }
        if(pedidoAsignado2 != null){
            pedidosAsignados++;
        }
        return pedidosAsignados;
    }

    public boolean puedeRecibirPedidos(){
        boolean response = (this.getPedidoAsignado1() == null || this.getPedidoAsignado2() == null);
        return response;
    }

    @Override
    public String toString() {
        return "************************\n" +
                "Nombre: " + getNombre() + "\n" +
                "Correo: " + getCorreo() + "\n" +
                "************************";
    }
}
