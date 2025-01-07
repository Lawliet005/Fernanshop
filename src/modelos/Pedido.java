package modelos;

import java.time.LocalDate;
import java.util.Random;

public class Pedido {
    private Cliente cliente;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;

    private String codigo;
    private LocalDate fechaEmitida; // +5 => fecha estimada
    private String estado; // En preparación, Retrasado, Cancelado, Enviado, Recibido
    private String comentario;

    public Pedido() {
        // Al crear un pedido se establecen los siguientes valores por defecto:
        fechaEmitida = LocalDate.now(); // Fecha actual
        estado = "En preparación";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    public LocalDate getFechaEmitida() {
        return fechaEmitida;
    }

    public void setFechaEmitida(LocalDate fechaEmitida) {
        this.fechaEmitida = fechaEmitida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    //Otros metodos

    public double totalPedido() {
        double totalPedido = 0;
        if (producto1 != null) {
        totalPedido += producto1.getPrecio();
        }
        if (producto2 != null){
            totalPedido += producto2.getPrecio();
        }
        if (producto3 != null){
            totalPedido += producto3.getPrecio();
        }

//        if (producto1 != null) {
//            totalPedido += producto1.getPrecio();
//        }
//        else if (producto2 != null){
//            totalPedido += producto2.getPrecio();
//        }
//        else if (producto3 != null){
//            totalPedido += producto3.getPrecio();
//        }
        return totalPedido;
    }
    public boolean aniadirProducto(Producto producto) {

        // Si todos los productos estan creados, por requisito no puede añadir más productos
        if (producto1 != null && producto2 != null && producto3 != null) return false;

        // Compruebo que producto esta sin crear y le asigno el producto
        if (producto1 == null) {
            producto1 = producto;
        } else if (producto2 == null) {
            producto2 = producto;
        } else {
            producto3 = producto;
        }
        return true;
    }
    // Aquí el toString
    @Override
    public String toString() {
        String apellido = "";
        if (cliente.getApellido() != null){
            apellido = cliente.getApellido();
        }
        String pedido = "\n" +
                "Estado: " + estado + "\n" +
                "Cliente: " + cliente.getNombre() + " " + apellido + "\n" +
                "Codigo Pedido: "+this.codigo+"\n"+
                "Direccion: " + cliente.getDireccion() + "\n" +
                "Localidad: " + cliente.getLocalidad() + "\n" +
                "Provincia: " + cliente.getProvincia() + "\n" +
                "Telefono: " + cliente.getTelefono() + "\n" +
                "Correo: " + cliente.getCorreo() + "\n" +
                "Fecha del pedido: " + LocalDate.now() + "\n" +
                "Comentario del pedido: " + ((comentario != null) ? comentario : "Sin comentarios") + "\n" +
                "Detalles del pedido: " + "\n" +
                "-" + producto1.getNombre() + " - " + producto1.getPrecio() + "€" + "\n";

        if (producto2 != null) {
            pedido += "-" + producto2.getNombre() + " - " + producto2.getPrecio() + "€" + "\n";
        }
        if (producto3 != null) {
            pedido = "-" + producto3.getNombre() + " - " +  producto3.getPrecio() + "€" + "\n";
        }
        pedido += "Total pedido: " + totalPedido() + "€";
        return pedido;
    }

    public String generarCodigoPedido(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(9000) + 1000;
        String response = "PED-"+numeroAleatorio;
        return response;
    }

}
