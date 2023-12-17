    import java.util.Scanner;
    import model.Cliente;
    import model.Empleado;
    import java.util.ArrayList;
    import java.util.List;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    
    public class Main {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Cliente cliente = null;
            Empleado empleado = null;
            List<String> pedidosBasicos = new ArrayList<>();
            List<String> pedidosPremium = new ArrayList<>();
            List<String> pedidosVIP = new ArrayList<>();
            List<Cliente> clientes = new ArrayList<>();
            List<Empleado> empleados = new ArrayList<>();

            cargarClientesDesdeBaseDeDatos(clientes);
            cargarEmpleadosDesdeBaseDeDatos(empleados);
            boolean salir = false;
    
            while (!salir) {
                System.out.println("Bienvenido a la funeraria. Seleccione una opción:");
                System.out.println("1. Registrarse como cliente");
                System.out.println("2. Iniciar sesión como cliente");
                System.out.println("3. Registrarse como empleado");
                System.out.println("4. Iniciar sesión como empleado");
    
                System.out.println("5. Salir");
    
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
    
                switch (opcion) {
                    case 1:
                        // Lógica para registrar un nuevo cliente
                        System.out.println("Registro de nuevo cliente:");
                        System.out.println("Ingrese su nombre completo y numero de celular:");
                        String nombreCliente = scanner.nextLine();
                        System.out.println("Ingrese su edad:");
                        String telefonoCliente = scanner.nextLine();
                        System.out.println("Crear un usuario:");
                        String usuarioCliente = scanner.nextLine();
                        System.out.println("Crear una contraseña:");
                        String contrasenaCliente = scanner.nextLine();
    
                        // Aquí puedes crear una instancia del cliente con los datos recopilados
                        cliente = new Cliente(nombreCliente, telefonoCliente, usuarioCliente, contrasenaCliente);
    
                        System.out.println("Cliente registrado exitosamente.");
                        Cliente nuevoCliente = new Cliente(nombreCliente, telefonoCliente, usuarioCliente, contrasenaCliente);
                        clientes.add(nuevoCliente); // Agregar el nuevo cliente a la lista
                        // Guardar el cliente en la base de datos
                        guardarClienteEnBaseDeDatos(cliente);
                        System.out.println("Cliente registrado exitosamente.");
                        break;
    
                    case 2:
                        // Lógica para iniciar sesión como cliente
    
                        if (cliente != null && !cliente.isSesionIniciada()) {
                            System.out.println("Ingrese su usuario:");
                            String usuarioIngresado = scanner.nextLine();
                            System.out.println("Ingrese su contraseña:");
                            String contraseñaIngresada = scanner.nextLine();
    
                            if (cliente.getUsuario().equals(usuarioIngresado) && cliente.getContraseña().equals(contraseñaIngresada)) {
                                cliente.iniciarSesion();
                                System.out.println("Sesión iniciada como cliente.");
    
                                boolean sesionCliente = true;
                                while (sesionCliente) {
                                    System.out.println("Menú cliente:");
                                    System.out.println("1. Ver servicios");
                                    System.out.println("2. Cerrar sesión");
                                    System.out.println("3. Volver al menú");
    
                                    int opcionCliente = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer del scanner
    
                                    switch (opcionCliente) {
                                        case 1:
                                            // Lógica para ver servicios
                                            System.out.println("Servicios disponibles:");
                                            System.out.println("1. Plan Básico");
                                            System.out.println("2. Plan Premium");
                                            System.out.println("3. Plan VIP");
                                            System.out.println("4. Cerrar sesión");
    
                                            int opcionServicios = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer del scanner

                                            // Dentro del switch (opcionServicios) para el menú del cliente
                                            switch (opcionServicios) {
                                                case 1:
                                                    System.out.println("Gestionando pedido del Plan Básico.");
                                                    System.out.println("Se le contactará vía WhatsApp al número registrado.");
                                                    guardarServicioEnBaseDeDatos("Plan Básico"); // Llamar a la función para guardar el servicio en la base de datos
                                                    pedidosBasicos.add("Pedido de Plan Básico"); // Añadir el pedido a la lista de pedidos básicos
                                                    break;
                                                case 2:
                                                    System.out.println("Gestionando pedido del Plan Premium.");
                                                    System.out.println("Se le contactará vía WhatsApp al número registrado.");
                                                    guardarServicioEnBaseDeDatos("Plan Premium"); // Llamar a la función para guardar el servicio en la base de datos
                                                    pedidosPremium.add("Pedido de Plan Premium"); // Añadir el pedido a la lista de pedidos premium
                                                    break;
                                                case 3:
                                                    System.out.println("Gestionando pedido del Plan VIP.");
                                                    System.out.println("Se le contactará vía WhatsApp al número registrado.");
                                                    guardarServicioEnBaseDeDatos("Plan VIP"); // Llamar a la función para guardar el servicio en la base de datos
                                                    pedidosVIP.add("Pedido de Plan VIP"); // Añadir el pedido a la lista de pedidos VIP
                                                    break;
                                                case 4:
                                                    cliente = null; // Cerrar la sesión del cliente
                                                    sesionCliente = false;
                                                    System.out.println("Sesión cerrada.");
                                                    break;
                                                default:
                                                    System.out.println("Opción inválida.");
                                                    break;
                                            }

                                        case 2:
                                            cliente = null; // Cerrar la sesión del cliente
                                            sesionCliente = false;
                                            System.out.println("Sesión cerrada.");
                                            break;
                                        case 3:
                                            sesionCliente = false; // Volver al menú principal
                                            break;
                                        default:
                                            System.out.println("Opción inválida.");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Credenciales incorrectas.");
                            }
                        } else {
                            System.out.println("No hay cliente registrado o ya ha iniciado sesión.");
                        }
                        break;
    
    
                    case 3:
                        System.out.println("Ingrese el nombre del empleado:");
                        String nombreEmpleado = scanner.nextLine();
                        System.out.println("Ingrese el número de celular del empleado:");
                        String celularEmpleado = scanner.nextLine();
                        System.out.println("Ingrese el usuario para el empleado:");
                        String usuarioEmpleado = scanner.nextLine();
                        System.out.println("Ingrese la contraseña para el empleado:");
                        String contraseñaEmpleado = scanner.nextLine();
    
                        // Crear una instancia de Empleado con los datos proporcionados
                        empleado = new Empleado(nombreEmpleado,  celularEmpleado, usuarioEmpleado, contraseñaEmpleado);
    
                        // Aquí puedes almacenar la instancia de empleado en la base de datos o donde corresponda
    
                        System.out.println("Empleado registrado exitosamente.");
    
             // Agregar el nuevo cliente a la lista
                        // Guardar el cliente en la base de datos
                        guardarEmpleadoEnBaseDeDatos(empleado);
                        System.out.println("Cliente registrado exitosamente.");
    
    
                        break;
                    case 4:
                        // Lógica para iniciar sesión como empleado
                        if (empleado != null && !empleado.isSesionIniciada()) {
                            System.out.println("Ingrese su usuario:");
                            String usuarioIngresado = scanner.nextLine();
                            System.out.println("Ingrese su contraseña:");
                            String contraseñaIngresada = scanner.nextLine();
    
                            if (empleado.getUsuario().equals(usuarioIngresado) && empleado.getContraseña().equals(contraseñaIngresada)) {
                                empleado.iniciarSesion();
                                System.out.println("Sesión iniciada como empleado.");
    
                                // Menú de opciones para el empleado
                                boolean sesionEmpleado = true;
                                while (sesionEmpleado) {
                                    System.out.println("Menú empleado:");
                                    System.out.println("1. Ver pedidos clientes");
                                    System.out.println("2. Ver clientes registrados");
                                    System.out.println("3. Volver al menú");
                                    System.out.println("4. Cerrar sesión");
    
                                    int opcionEmpleado = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer del scanner
    
                                    switch (opcionEmpleado) {
                                        case 1:
                                            // Lógica para ver pedidos de clientes
                                            System.out.println("Pedidos de clientes:");
                                            System.out.println("1. Plan Básico");
                                            System.out.println("2. Plan Premium");
                                            System.out.println("3. Plan VIP");
                                            System.out.println("4. Volver al menú");
    
                                            int opcionPedidos = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer del scanner
    
                                            switch (opcionPedidos) {
                                                case 1:
                                                    // Lógica para mostrar pedidos del Plan Básico
                                                    for (String pedido : pedidosBasicos) {
                                                        System.out.println("- " + pedido);
                                                    }
                                                    break;
                                                case 2:
                                                    // Lógica para mostrar pedidos del Plan Premium
                                                    for (String pedido : pedidosPremium) {
                                                        System.out.println("- " + pedido);
                                                    }
                                                    break;
                                                case 3:
                                                    // Lógica para mostrar pedidos del Plan VIP
                                                    for (String pedido : pedidosVIP) {
                                                        System.out.println("- " + pedido);
                                                    }
                                                    break;
                                                case 4:
                                                    // Volver al menú anterior
                                                    break;
                                                default:
                                                    System.out.println("Opción inválida.");
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Clientes registrados:");
                                            verClientesRegistrados(); // Llamar a la función para mostrar los clientes
                                            break;
    
    
                                        case 3:
                                            // Volver al menú anterior
                                            sesionEmpleado = false;
                                            break;
                                        default:
                                            System.out.println("Opción inválida.");
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Credenciales incorrectas.");
                            }
                        } else {
                            System.out.println("No hay empleado registrado o ya ha iniciado sesión.");
                        }
                        break;
    
    
                }
    
            }
    
            scanner.close();
    
        }
        public static void cargarClientesDesdeBaseDeDatos(List<Cliente> clientes) {
            String url = "jdbc:mysql://localhost:3306/funeraria";
            String usuarioDB = "root";
            String contraseñaDB = "";
            String sql = "SELECT nombre_completo, celular, usuario, contraseña FROM clientes";

            try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {

                    String nombre = rs.getString("nombre_completo");
                    String celular = rs.getString("celular");
                    String usuario = rs.getString("usuario");
                    String contraseña = rs.getString("contraseña");

                    Cliente cliente = new Cliente(nombre, celular, usuario, contraseña);
                    clientes.add(cliente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void cargarEmpleadosDesdeBaseDeDatos(List<Empleado> empleados) {
            String url = "jdbc:mysql://localhost:3306/funeraria";
            String usuarioDB = "root";
            String contraseñaDB = "";
            String sql = "SELECT nombre, celular, usuario, contraseña FROM empleados";

            try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String celular = rs.getString("celular");
                    String usuario = rs.getString("usuario");
                    String contraseña = rs.getString("contraseña");

                    Empleado empleado = new Empleado(nombre, celular, usuario, contraseña);
                    empleados.add(empleado);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        public static void guardarClienteEnBaseDeDatos(Cliente cliente) {
            // Configuración de la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/funeraria";
            String usuarioDB = "root";
            String contraseñaDB = "";
    
            // Consulta SQL para insertar un nuevo cliente en la tabla 'clientes'
            String sql = "INSERT INTO clientes (nombre_completo, celular, usuario, contraseña) VALUES (?, ?, ?, ?)";
    
            try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                // Establecer los valores del cliente en la consulta SQL
                pstmt.setString(1, cliente.getNombre()); // nombre_completo
                pstmt.setString(2, cliente.getCelular()); // celular
                pstmt.setString(3, cliente.getUsuario()); // usuario
                pstmt.setString(4, cliente.getContraseña()); // contraseña
    
                // Ejecutar la consulta para insertar el cliente en la base de datos
                pstmt.executeUpdate();
    
                System.out.println("Cliente guardado en la base de datos.");
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        public static void guardarServicioEnBaseDeDatos(String nombreServicio) {
            String url = "jdbc:mysql://localhost:3306/funeraria";
            String usuarioDB = "root";
            String contraseñaDB = "";
            String sql = "INSERT INTO servicios (nombre_servicio) VALUES (?)";

            try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombreServicio);
                pstmt.executeUpdate();
                System.out.println("Servicio '" + nombreServicio + "' agregado a la base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void guardarEmpleadoEnBaseDeDatos(Empleado empleado) {
            String url = "jdbc:mysql://localhost:3306/funeraria";
            String usuarioDB = "root";
            String contraseñaDB = "";
    
            String sql = "INSERT INTO empleados (nombre, celular, usuario, contraseña) VALUES (?, ?, ?, ?)";
    
            try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                pstmt.setString(1, empleado.getNombre());
                pstmt.setString(2, empleado.getCelular());
                pstmt.setString(3, empleado.getUsuario());
                pstmt.setString(4, empleado.getContraseña());
    
                pstmt.executeUpdate();
    
                System.out.println("Empleado guardado en la base de datos.");
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void verClientesRegistrados() {
            String url = "jdbc:mysql://localhost:3306/funeraria";
            String usuarioDB = "root";
            String contraseñaDB = "";
    
            String sql = "SELECT nombre_completo FROM clientes";
    
            try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                ResultSet rs = pstmt.executeQuery();
    
                System.out.println("Clientes registrados:");
                while (rs.next()) {
                    String nombreCliente = rs.getString("nombre_completo");
                    System.out.println("- " + nombreCliente);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
    
