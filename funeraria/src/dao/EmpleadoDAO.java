// EmpleadoDAO.java
package dao;

import model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/funeraria";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {

                String nombre = rs.getString("nombre_completo");
                String celular = rs.getString("celular");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");

                Empleado empleado = new Empleado(nombre,  celular, usuario, contraseña);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Resto de métodos para agregar, actualizar y eliminar empleados...
}
