import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/funeraria"; // Reemplaza con tu URL de conexión
        String usuarioDB = "root"; // Reemplaza con tu usuario
        String contraseñaDB = ""; // Reemplaza con tu contraseña

        return DriverManager.getConnection(url, usuarioDB, contraseñaDB);
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
