import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/funeraria";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conexion;

    public static Connection obtenerConexion() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
