import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasBD {

    private static final String URL = "jdbc:mysql://localhost:3306/funeraria";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            // Establecer la conexión con la base de datos
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Consulta para obtener todos los clientes
            String consultaClientes = "SELECT * FROM clientes";
            PreparedStatement psClientes = conn.prepareStatement(consultaClientes);
            ResultSet rsClientes = psClientes.executeQuery();

            // Imprimir información de los clientes
            while (rsClientes.next()) {
                int idCliente = rsClientes.getInt("id");
                String nombreCompleto = rsClientes.getString("nombre_completo");
                String celular = rsClientes.getString("celular");
                String usuario = rsClientes.getString("usuario");
                String contraseña = rsClientes.getString("contraseña");

                System.out.println("ID: " + idCliente + ", Nombre: " + nombreCompleto +
                        ", Celular: " + celular + ", Usuario: " + usuario + ", Contraseña: " + contraseña);
            }

            // Cerrar recursos
            rsClientes.close();
            psClientes.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
