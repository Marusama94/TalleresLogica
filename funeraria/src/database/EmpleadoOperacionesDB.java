package database;

import model.Cliente;
import model.ServicioComprado;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoOperacionesDB {
    private static final String URL = "jdbc:mysql://localhost:3306/funeraria";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Métodos existentes...

    public void modificarInformacionCliente(int idCliente, String nuevoNombre, String nuevoCelular, String nuevoUsuario, String nuevaContraseña) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE clientes SET nombre_completo = ?, celular = ?, usuario = ?, contraseña = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoCelular);
            pstmt.setString(3, nuevoUsuario);
            pstmt.setString(4, nuevaContraseña);
            pstmt.setInt(5, idCliente);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para otras operaciones en la base de datos...
}
