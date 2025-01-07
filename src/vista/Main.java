package vista;

import modelos.*;

import javax.swing.text.html.parser.Parser;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final String TIENDA = "FERNANSHOP";
        Cliente cliente1 = new Cliente("Javier", "Martos", "javier@gmail.com", "1234", "722270621", "Calle El Pozo", "Martos", "Jaen");
        Cliente cliente2 = null;
        Cliente clienteCopia = null;
        Trabajador trabajador1 = new Trabajador("Marcos", "marcos@gmail.com", "1234");
        Trabajador trabajador2 = new Trabajador("Juan","juan@gmail.com","1234");
        Trabajador trabajador3 = new Trabajador("David","david@gmail.com","1234");
        Trabajador trabajadorCopia = null;
        Administrador administrador = new Administrador("admin", "admin.admin@fernanshop.com", "adminfer");
        String opcion;
        String correo, contrasenia, direccion, telefono, localidad, provincia;
        boolean esMenuAdministrador = false;
        boolean esMenuTrabajador = false;
        int numPedidos = 0;


        // Cliente * 2 Pedidos -> 3 Productos max por pedido:
        // Total de productos a crear:

        // Crear productos para el catálogo de productos:
        Producto xiaomiMi10 = new Producto("AB-0001", "Xiaomi Mi 10", 300);
        Producto macbookAir = new Producto("AP-0002", "Macbook Air", 1300);
        Producto monitorLG = new Producto("XG-0003", "Monitor LG 22\" ", 500);
        Producto altavocesLogitech = new Producto("HU-0004", "Altavoces Logitech", 200);
        Producto microfonoKrom = new Producto("YT-0005", "Microfono Krom , USB , 3.5", 60);

        do {
            // Menú principal
            final String FERNANSHOP = """
                    
                      ____    _____   ______   _   _  __      __  ______   _   _   _____   _____     ____                   ______   ______   _____    _   _              _   _    _____   _    _    ____    _____    _\s
                     |  _ \\  |_   _| |  ____| | \\ | | \\ \\    / / |  ____| | \\ | | |_   _| |  __ \\   / __ \\        /\\       |  ____| |  ____| |  __ \\  | \\ | |     /\\     | \\ | |  / ____| | |  | |  / __ \\  |  __ \\  | |
                     | |_) |   | |   | |__    |  \\| |  \\ \\  / /  | |__    |  \\| |   | |   | |  | | | |  | |      /  \\      | |__    | |__    | |__) | |  \\| |    /  \\    |  \\| | | (___   | |__| | | |  | | | |__) | | |
                     |  _ <    | |   |  __|   | . ` |   \\ \\/ /   |  __|   | . ` |   | |   | |  | | | |  | |     / /\\ \\     |  __|   |  __|   |  _  /  | . ` |   / /\\ \\   | . ` |  \\___ \\  |  __  | | |  | | |  ___/  | |
                     | |_) |  _| |_  | |____  | |\\  |    \\  /    | |____  | |\\  |  _| |_  | |__| | | |__| |    / ____ \\    | |      | |____  | | \\ \\  | |\\  |  / ____ \\  | |\\  |  ____) | | |  | | | |__| | | |      |_|
                     |____/  |_____| |______| |_| \\_|     \\/     |______| |_| \\_| |_____| |_____/   \\____/    /_/    \\_\\   |_|      |______| |_|  \\_\\ |_| \\_| /_/    \\_\\ |_| \\_| |_____/  |_|  |_|  \\____/  |_|      (_)
                                                                                                                                                                                                                       \s
                                                                                                                                                                                                                       \s
                    """;
            System.out.println(FERNANSHOP);
            System.out.println("""
                    ===================|
                    1. Iniciar sesión  |
                    2. Registrarse     |
                    3. Salir           |
                    ===================|
                    """);

            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingresa tú correo: ");
                    correo = scanner.nextLine();

                    System.out.println("Ingresa tu contraseña: ");
                    contrasenia = scanner.nextLine();

                    if (correo.isEmpty() || contrasenia.isEmpty()) {
                        System.out.println("Los campos no pueden estar vacios");
                    } else {

                        if (cliente1 != null && (cliente1.getCorreo().equalsIgnoreCase(correo) && cliente1.getContrasenia().equalsIgnoreCase(contrasenia))) {
                            clienteCopia = cliente1;
                        } else if (cliente2 != null && (cliente2.getCorreo().equalsIgnoreCase(correo) && cliente2.getContrasenia().equalsIgnoreCase(contrasenia))) {
                            clienteCopia = cliente2;
                        } else if (administrador.getCorreo().equalsIgnoreCase(correo) && administrador.getContrasenia().equalsIgnoreCase(contrasenia)) {
                            esMenuAdministrador = true;
                        } else if (trabajador1 != null && trabajador1.getCorreo().equalsIgnoreCase(correo) && trabajador1.getContrasenia().equalsIgnoreCase(contrasenia)) {
                            trabajadorCopia = trabajador1;
                            esMenuTrabajador = true;
                        } else
                            System.out.println("No se pudo iniciar sesión, correo y/o contraseña incorrectas.");
                        // Menu del cliente
                        if (clienteCopia != null) {

                            String opcionMenuCliente;
                            do {
                                // Menú perfil cliente
                                System.out.println(TIENDA);
                                System.out.printf("Bienvenido %s\n", clienteCopia.getNombre());
                                System.out.println("""
                                        ======================================|
                                        1. Consultar el catálogo de productos |
                                        2. Realizar un pedido                 |
                                        3. Ver mis pedidos realizados         |
                                        4. Ver mis datos personales           |
                                        5. Modificar mis datos personales     |
                                        6. Cerrar sesión                      |
                                        ======================================|
                                        """);

                                opcionMenuCliente = scanner.nextLine();

                                switch (opcionMenuCliente) {
                                    case "1":
                                        System.out.println("CATÁLOGO DE PRODUCTOS");
                                        System.out.println("=".repeat(20)); // Linea divisora (====================)
                                        System.out.println(xiaomiMi10);
                                        System.out.println(macbookAir);
                                        System.out.println(monitorLG);
                                        System.out.println(altavocesLogitech);
                                        System.out.println(microfonoKrom);
                                        break;
                                    case "2":
                                        // Comprobar si nuestro usuario tiene al menos un pedido por hacer disponible
                                        // Como requisito nos especifican que solo puede tener 2 pedidos
                                        if (clienteCopia.getPedido1() != null && clienteCopia.getPedido2() != null) {
                                            System.out.println("No puedes crear más pedidos, has superado el limite (2)");
                                        } else {
                                            Producto productoElegido = null;
                                            Pedido nuevoPedido = new Pedido();
                                            nuevoPedido.setCodigo(nuevoPedido.generarCodigoPedido());
                                            boolean codigoErroneo = false;

                                            for (int i = 0; i < 3; i++) {

                                                if (i == 2) {
                                                    System.out.println("Has superado el limite de productos por pedido (3)");
                                                    break;
                                                }

                                                // Obtener el código del producto
                                                System.out.println("¿Indica el código del producto que vas a elegir?:");
                                                String codigoProducto = scanner.nextLine();
                                                // Comparar los productos de mi catálogo para encontrar el producto elegido
                                                if (xiaomiMi10.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                    productoElegido = xiaomiMi10;
                                                } else if (macbookAir.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                    productoElegido = macbookAir;
                                                } else if (monitorLG.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                    productoElegido = monitorLG;
                                                } else if (altavocesLogitech.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                    productoElegido = altavocesLogitech;
                                                } else if (microfonoKrom.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                    productoElegido = microfonoKrom;
                                                } else {
                                                    System.out.println("Código de producto erroneo");
                                                    codigoErroneo = true;
                                                    break;
                                                }

                                                // Asignar los productos al pedido
                                                if (nuevoPedido.aniadirProducto(productoElegido)) {
                                                    System.out.println("Producto añadido correctamente al carrito");
                                                }
                                                System.out.println("¿Quieres comprar más productos: s/n?");
                                                String respuesta = scanner.nextLine();

                                                if (respuesta.equalsIgnoreCase("n")) break;
                                            }

                                            // Salimos del case 2 porque han indicado mál el código de producto
                                            if (codigoErroneo) break;

                                            // Vamos a verificar a que pedido del cliente le asignamos el nuevo pedido
                                            // Tenemos que evaluar si el pedido1 es nulo o el pedido2 es nulo
                                            // Asignar el pedido al cliente2

                                            if (clienteCopia.getPedido1() == null) {
                                                nuevoPedido.setCliente(clienteCopia);
                                                clienteCopia.setPedido1(nuevoPedido);
                                                System.out.println("Pedido realizado");
                                            } else if (clienteCopia.getPedido2() == null) {
                                                nuevoPedido.setCliente(clienteCopia);
                                                clienteCopia.setPedido2(nuevoPedido);
                                                System.out.println("Pedido realizado");
                                            }
                                        }
                                        break;
                                    case "3":
                                        // Comprueba que los pedidos existan o esten creados
                                        if (cliente1.getPedido1() != null) {
                                            System.out.println(cliente1.getPedido1());
                                        } else if (cliente2.getPedido2() != null) {
                                            System.out.println(cliente2.getPedido2());
                                        } else
                                            System.out.println("El cliente no tiene pedidos");
                                        break;
                                    case "4":
                                        //System.out.println(clienteCopia);
                                        if (cliente1 != null || cliente2 != null){
                                            System.out.println(cliente1);
                                            System.out.println(cliente2);
                                        }
                                        break;
                                    case "5":
                                        System.out.println("Ingresa tu nombre: ");
                                        String nombre = scanner.nextLine();

                                        System.out.println("Ingresa tú correo: ");
                                        correo = scanner.nextLine();

                                        System.out.println("Ingresa tu contraseña: ");
                                        contrasenia = scanner.nextLine();

                                        System.out.println("Ingresa tu direccion: ");
                                        direccion = scanner.nextLine();

                                        System.out.println("Ingresa tu telefono: ");
                                        telefono = scanner.nextLine();

                                        System.out.println("Ingresa tu localidad: ");
                                        localidad = scanner.nextLine();

                                        System.out.println("Ingresa tu provincia: ");
                                        provincia = scanner.nextLine();

                                        if (correo.isEmpty() || contrasenia.isEmpty() || nombre.isEmpty() || direccion.isEmpty()
                                                || telefono.isEmpty() || localidad.isEmpty() || provincia.isEmpty()) {
                                            System.out.println("Los campos no pueden estar vacios");
                                        }
                                        clienteCopia.setCorreo(correo);
                                        clienteCopia.setContrasenia(contrasenia);
                                        clienteCopia.setNombre(nombre);
                                        clienteCopia.setDireccion(direccion);
                                        clienteCopia.setTelefono(telefono);
                                        clienteCopia.setLocalidad(localidad);
                                        clienteCopia.setProvincia(provincia);

                                        System.out.println("Usuario modificado");
                                        break;
                                    case "6":
                                        clienteCopia = null;
                                        System.out.println("Cerrando sesion, espere por favor...");
                                    default:
                                        break;
                                }
                            } while (!opcionMenuCliente.equalsIgnoreCase("6"));

                        } else if (esMenuAdministrador) {

                            String opcionMenuAdministrador;

                            do {
                                // Menú administrador
                                System.out.println(TIENDA);
                                System.out.printf("Bienvenido %s\n", administrador.getNombre());
                                System.out.println("1. Asignar un pedido a un trabajador");
                                System.out.println("2. Modificar el estado de un pedido");
                                System.out.println("3. Dar de alta a un trabajador");
                                System.out.println("4. Ver todos los pedidos");
                                System.out.println("5. Ver todos los clientes");
                                System.out.println("6. Ver todos los trabajadores");
                                System.out.println("7. Cerrar sesión");

                                opcionMenuAdministrador = scanner.nextLine();

                                switch (opcionMenuAdministrador) {
                                    case "1":
                                        System.out.println("Indica el codigo del pedido que deasea asignar...");
                                        String codigoPedio = scanner.nextLine();
                                        Pedido pedidoEncontrado = null;

                                        //BUSCAMOS EL PEDIDO EN LOS CLIENTES
                                        if(cliente1 != null){
                                            if(cliente1.getPedido1() != null && cliente1.getPedido1().getCodigo().equalsIgnoreCase(codigoPedio)){
                                                pedidoEncontrado = cliente1.getPedido1();
                                            }else if(cliente1.getPedido2() != null && cliente1.getPedido2().getCodigo().equalsIgnoreCase(codigoPedio)){
                                                pedidoEncontrado = cliente1.getPedido2();
                                            }
                                        }

                                        if(cliente2 != null && pedidoEncontrado == null){
                                            if(cliente2.getPedido1() != null && cliente2.getPedido1().getCodigo().equalsIgnoreCase(codigoPedio)){
                                                pedidoEncontrado = cliente2.getPedido1();
                                            }else if(cliente2.getPedido2() != null && cliente2.getPedido2().getCodigo().equalsIgnoreCase(codigoPedio)){
                                                pedidoEncontrado = cliente2.getPedido2();
                                            }
                                        }

                                        if(pedidoEncontrado == null){
                                            System.out.println("NO SE ENCUENTRA NINGUN PEDIDO CON ESE CODIGO");
                                        }else if(!pedidoEncontrado.getEstado().equalsIgnoreCase("En preparación")){
                                            System.out.println("El pedido no esta disponible para ser asignado....(estado actual: "+pedidoEncontrado.getEstado()+")");
                                        }else{
                                            Trabajador trabajadorDisponible = null;
                                            if(trabajador1.puedeRecibirPedidos()){
                                                trabajadorDisponible = trabajador1;
                                            }else if(trabajador2.puedeRecibirPedidos()){
                                                trabajadorDisponible = trabajador2;
                                            }else if(trabajador3.puedeRecibirPedidos()){
                                                trabajadorDisponible = trabajador3;
                                            }
                                            //ASIGNAMOS EL PEDIDO A UN TRABAJADOR
                                            if(trabajadorDisponible != null){
                                                trabajadorDisponible.asignarPedido(pedidoEncontrado);
                                                pedidoEncontrado.setEstado("Asignado");

                                            }else{
                                                System.out.println("NO HAY TRABAJADORES DISPONIBLES PARA ASIGNAR");
                                            }
                                        }

                                        /*if (trabajador1 != null) {
                                            if (cliente1.getPedido1() != null) {
                                                if (cliente1.getPedido1().getEstado().equalsIgnoreCase("En preparación")) {
                                                    trabajador1.asignarPedido(cliente1.getPedido1());
                                                    cliente1.getPedido1().setEstado("Asignado");
                                                }
                                            }

                                            if (cliente2.getPedido2() != null) {
                                                if (cliente2.getPedido2().getEstado().equalsIgnoreCase("En preparación")) {
                                                    trabajador1.asignarPedido(cliente2.getPedido2());
                                                    cliente2.getPedido2().setEstado("Asignado");
                                                }
                                            }
                                        }*/
                                        break;
                                    case "2":
                                        System.out.println("Indica el codigo del pedido que deasea asignar...");
                                        String codigoPedido = scanner.nextLine();
                                        pedidoEncontrado = null;

                                        //BUSCAMOS EL PEDIDO EN LOS CLIENTES
                                        if(cliente1 != null){
                                            if(cliente1.getPedido1() != null && cliente1.getPedido1().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente1.getPedido1();
                                            }else if(cliente1.getPedido2() != null && cliente1.getPedido2().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente1.getPedido2();
                                            }
                                        }

                                        if(cliente2 != null && pedidoEncontrado == null){
                                            if(cliente2.getPedido1() != null && cliente2.getPedido1().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente2.getPedido1();
                                            }else if(cliente2.getPedido2() != null && cliente2.getPedido2().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente2.getPedido2();
                                            }
                                        }

                                        if(pedidoEncontrado == null){
                                            System.out.println("NO SE ENCUENTRA NINGUN PEDIDO CON ESE CODIGO");
                                        }else{
                                            System.out.println("El estado actual del pedido "+pedidoEncontrado.getCodigo()+" es: "+pedidoEncontrado.getEstado());
                                            System.out.println("Seleccione el nuevo estado: ");
                                            System.out.println("1. Recibido");
                                            System.out.println("2. En Preparacion");
                                            System.out.println("3. Retrasado");
                                            System.out.println("4. Cancelado");
                                            System.out.println("5. Enviado");

                                            int opcionElegidaEstado = scanner.nextInt();
                                            scanner.nextLine();

                                            String nuevoEstado = pedidoEncontrado.getEstado();

                                            switch (opcionElegidaEstado){
                                                case 1:
                                                    nuevoEstado = "Recibido";
                                                    break;
                                                case 2:
                                                    nuevoEstado = "En Preparacion";
                                                    break;
                                                case 3:
                                                    nuevoEstado = "Retrasado";
                                                    break;
                                                case 4:
                                                    nuevoEstado = "Cancelado";
                                                    break;
                                                case 5:
                                                    nuevoEstado = "Enviado";
                                                    break;
                                                default:
                                                    System.out.println("Opcion no valida, No se modifica el estado");
                                                    return;
                                            }
                                            pedidoEncontrado.setEstado(nuevoEstado);
                                            System.out.println("Cambio de Estado actual del pedido "+pedidoEncontrado.getCodigo()+" es: "+pedidoEncontrado.getEstado());
                                        }

                                        break;
                                    case "3":
                                        if (trabajador1 == null || trabajador2 == null || trabajador3 == null) {
                                            System.out.println();
                                        }
                                        break;
                                    case "4":
                                        String texto = "";
                                        if (cliente1 != null) {
                                            if (cliente1.getPedido1() != null) {
                                                texto += cliente1.getPedido1() + "\n";
                                            }
                                            if (cliente1.getPedido2() != null) {
                                                texto += cliente1.getPedido2() + "\n";
                                            }
                                        }
                                        if (cliente2 != null) {
                                            if (cliente2.getPedido1() != null) {
                                                texto += cliente2.getPedido1() + "\n";
                                            }
                                            if (cliente2.getPedido2() != null) {
                                                texto += cliente2.getPedido2() + "\n";
                                            }
                                        }
                                        System.out.println(texto);
                                        break;
                                    case "5":
                                        if (cliente1 != null || cliente2 != null) {
                                            System.out.println(cliente1);
                                            System.out.println(cliente2);
                                        } else
                                            System.out.println("No hay clientes por el momento");
                                        break;
                                    case "6":
                                        if (trabajador1 != null || trabajador2 != null || trabajador3 != null) {
                                            System.out.println(trabajador1);
                                            System.out.println(trabajador2);
                                            System.out.println(trabajador3);
                                        } else
                                            System.out.println("No hay trabajadores por el momento");
                                        break;
                                    case "7":
                                        esMenuAdministrador = false;
                                        System.out.println("Cerrando sesion, espere por favor...");
                                    default:
                                        break;
                                }

                            } while (!opcionMenuAdministrador.equalsIgnoreCase("7"));

                        } else if (trabajadorCopia != null) {
                            String opcionMenuTrabajador;
                            do {
                                // Menú trabajador
                                System.out.println(TIENDA);
                                System.out.println("Bienvenido" + " " + trabajadorCopia.getNombre() + " " + "tienes" + " " + trabajadorCopia.contarPedidosAsignados() + " " + "pedidos" + " " + "a gestionar");
                                System.out.println("1. Consultar los pedidos que tengo asignados");
                                System.out.println("2. Modificar el estado de un pedido");
                                System.out.println("3.Consultar el catalogo de productos");
                                System.out.println("4.Modificar un producto del catalogo");
                                System.out.println("5.Ver mi perfil");
                                System.out.println("6.Modificar mis datos personales");
                                System.out.println("7. Cerrar sesión");

                                opcionMenuTrabajador = scanner.nextLine();

                                switch (opcionMenuTrabajador) {
                                    case "1":
                                        if (trabajador1 != null){
                                            System.out.println(trabajador1.getPedidoAsignado1());
                                            System.out.println(trabajador1.getPedidoAsignado2());
                                        } else if (trabajador2 != null) {
                                            System.out.println(trabajador2.getPedidoAsignado1());
                                            System.out.println(trabajador2.getPedidoAsignado2());
                                        }else if (trabajador3 != null) {
                                            System.out.println(trabajador3.getPedidoAsignado1());
                                            System.out.println(trabajador3.getPedidoAsignado2());
                                        }else
                                        System.out.println("Por el momento no tienes ningun pedido asignado");
                                        break;
                                    case "2":
                                        System.out.println("Indica el codigo del pedido que deasea asignar...");
                                        String codigoPedido = scanner.nextLine();
                                        Pedido pedidoEncontrado = null;

                                        //BUSCAMOS EL PEDIDO EN LOS CLIENTES
                                        if(cliente1 != null){
                                            if(cliente1.getPedido1() != null && cliente1.getPedido1().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente1.getPedido1();
                                            }else if(cliente1.getPedido2() != null && cliente1.getPedido2().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente1.getPedido2();
                                            }
                                        }
                                        if(cliente2 != null && pedidoEncontrado == null){
                                            if(cliente2.getPedido1() != null && cliente2.getPedido1().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente2.getPedido1();
                                            }else if(cliente2.getPedido2() != null && cliente2.getPedido2().getCodigo().equalsIgnoreCase(codigoPedido)){
                                                pedidoEncontrado = cliente2.getPedido2();
                                            }
                                        }

                                        if(pedidoEncontrado == null){
                                            System.out.println("NO SE ENCUENTRA NINGUN PEDIDO CON ESE CODIGO");
                                        }else{
                                            System.out.println("El estado actual del pedido "+pedidoEncontrado.getCodigo()+" es: "+pedidoEncontrado.getEstado());
                                            System.out.println("Seleccione el nuevo estado: ");
                                            System.out.println("1. Recibido");
                                            System.out.println("2. En Preparacion");
                                            System.out.println("3. Retrasado");
                                            System.out.println("4. Cancelado");
                                            System.out.println("5. Enviado");

                                            int opcionElegidaEstado = scanner.nextInt();
                                            scanner.nextLine();

                                            String nuevoEstado = pedidoEncontrado.getEstado();

                                            switch (opcionElegidaEstado){
                                                case 1:
                                                    nuevoEstado = "Recibido";
                                                    break;
                                                case 2:
                                                    nuevoEstado = "En Preparacion";
                                                    break;
                                                case 3:
                                                    nuevoEstado = "Retrasado";
                                                    break;
                                                case 4:
                                                    nuevoEstado = "Cancelado";
                                                    break;
                                                case 5:
                                                    nuevoEstado = "Enviado";
                                                    break;
                                                default:
                                                    System.out.println("Opcion no valida, No se modifica el estado");
                                                    return;
                                            }
                                            pedidoEncontrado.setEstado(nuevoEstado);
                                            System.out.println("Cambio de Estado actual del pedido "+pedidoEncontrado.getCodigo()+" es: "+pedidoEncontrado.getEstado());
                                        }
                                        break;
                                    case "3":
                                        System.out.println("CATÁLOGO DE PRODUCTOS");
                                        System.out.println("=".repeat(20)); // Linea divisora (====================)
                                        System.out.println(xiaomiMi10);
                                        System.out.println(macbookAir);
                                        System.out.println(monitorLG);
                                        System.out.println(altavocesLogitech);
                                        System.out.println(microfonoKrom);
                                        break;
                                    case "4":
                                        if (xiaomiMi10 == null && macbookAir == null && monitorLG == null && altavocesLogitech == null && microfonoKrom == null) {
                                            System.out.println("Debes crear un producto");
                                        } else {
                                            System.out.println("Mostrando lista de productos: ");

                                            if (xiaomiMi10 != null) {
                                                System.out.println(xiaomiMi10);
                                            } else if (macbookAir != null) {
                                                System.out.println(macbookAir);
                                            } else if (monitorLG != null) {
                                                System.out.println(monitorLG);
                                            } else if (altavocesLogitech != null) {
                                                System.out.println(altavocesLogitech);
                                            } else {
                                                System.out.println(microfonoKrom);
                                            }
                                            System.out.println("Elige un producto indicando su codigo: ");
                                            String codigoProducto = scanner.nextLine();

                                            if (xiaomiMi10 != null && xiaomiMi10.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                System.out.println("Introduce el nombre");
                                                String nombre = scanner.nextLine();
                                                System.out.println("Introduce el precio");
                                                double precio = Double.parseDouble(scanner.nextLine());
                                                // Setters
                                                xiaomiMi10.setNombre(nombre);
                                                xiaomiMi10.setPrecio(precio);
                                                System.out.println("Producto modificado");
                                            } else if (macbookAir != null && macbookAir.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                System.out.println("Introduce el nombre");
                                                String nombre = scanner.nextLine();
                                                System.out.println("Introduce el precio");
                                                double precio = Double.parseDouble(scanner.nextLine());
                                                // Setters
                                                macbookAir.setNombre(nombre);
                                                macbookAir.setPrecio(precio);
                                                System.out.println("Producto modificado");
                                            } else if (monitorLG != null && monitorLG.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                System.out.println("Introduce el nombre");
                                                String nombre = scanner.nextLine();
                                                System.out.println("Introduce el precio");
                                                double precio = Double.parseDouble(scanner.nextLine());
                                                // Setters
                                                monitorLG.setNombre(nombre);
                                                monitorLG.setPrecio(precio);
                                                System.out.println("Producto modificado");
                                            } else if (altavocesLogitech != null && altavocesLogitech.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                System.out.println("Introduce el nombre");
                                                String nombre = scanner.nextLine();
                                                System.out.println("Introduce el precio");
                                                double precio = Double.parseDouble(scanner.nextLine());
                                                // Setters
                                                altavocesLogitech.setNombre(nombre);
                                                altavocesLogitech.setPrecio(precio);
                                                System.out.println("Producto modificado");
                                            } else if (microfonoKrom != null && microfonoKrom.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                                System.out.println("Introduce el nombre");
                                                String nombre = scanner.nextLine();
                                                System.out.println("Introduce el precio");
                                                double precio = Double.parseDouble(scanner.nextLine());

                                                // Setters
                                                microfonoKrom.setNombre(nombre);
                                                microfonoKrom.setPrecio(precio);
                                                System.out.println("Producto modificado");
                                            } else {
                                                System.out.println("El codigo indicado no coincide con ninguno de los productos");
                                            }
                                        }
                                        break;
                                    case "5":
                                        System.out.println(trabajadorCopia);
                                        break;
                                    case "6":
                                        System.out.println("Ingresa tu nombre: ");
                                        String nombre = scanner.nextLine();

                                        System.out.println("Ingresa tú correo: ");
                                        correo = scanner.nextLine();

                                        System.out.println("Ingresa tu contraseña: ");
                                        contrasenia = scanner.nextLine();

                                        if (nombre.isEmpty() || correo.isEmpty() || contrasenia.isEmpty()) {
                                            System.out.println("Los campos no pueden estar vacios");
                                        }
                                        trabajadorCopia.setNombre(nombre);
                                        trabajadorCopia.setCorreo(correo);
                                        trabajadorCopia.setContrasenia(contrasenia);
                                        System.out.println("Usuario modificado");
                                        break;
                                    case "7":
                                        esMenuAdministrador = false;
                                        System.out.println("Cerrando sesion, espere por favor...");
                                    default:
                                        break;
                                }
                            }
                            while (!opcionMenuTrabajador.equalsIgnoreCase("7"));
                        }
                    }
                    break;
                case "2":
                    if (cliente1 != null && cliente2 != null) {
                        System.out.println("Ya hay usuarios registrados");
                    } else {
                        System.out.println("Ingresa tu nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Ingresa tú correo: ");
                        correo = scanner.nextLine();

                        System.out.println("Ingresa tu contraseña: ");
                        contrasenia = scanner.nextLine();

                        System.out.println("Ingresa tu direccion: ");
                        direccion = scanner.nextLine();

                        System.out.println("Ingresa tu telefono: ");
                        telefono = scanner.nextLine();

                        System.out.println("Ingresa tu localidad: ");
                        localidad = scanner.nextLine();

                        System.out.println("Ingresa tu provincia: ");
                        provincia = scanner.nextLine();
                        // Validaciones

                        if (correo.isEmpty() || contrasenia.isEmpty() || nombre.isEmpty() || direccion.isEmpty()
                                || telefono.isEmpty() || localidad.isEmpty() || provincia.isEmpty()) {
                            System.out.println("Los campos no pueden estar vacios");
                        }

                        if (cliente1 == null) {
                            cliente1 = new Cliente(nombre, correo, contrasenia, direccion, telefono, localidad, provincia);

                        } else {
                            cliente2 = new Cliente(nombre, correo, contrasenia, direccion, telefono, localidad, provincia);
                        }
                        System.out.println("Cliente registrado");
                    }
                    break;
                case "3":
                    System.out.println("Saliendo.....");
                default:
                    break;
            }

        } while (!opcion.equalsIgnoreCase("3"));

    }

}

