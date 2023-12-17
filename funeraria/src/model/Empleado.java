// Empleado.java
package model;

public class Empleado {

    private String nombre;

    private String celular;
    private String usuario;
    private String contraseña;
    private boolean sesionIniciada; // Agregar esta variable

    public Empleado(String nombre, String celular, String usuario, String contraseña) {
        this.nombre = nombre;
        this.celular = celular;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.sesionIniciada = false; // Por defecto, la sesión no está iniciada
    }

    // Resto de tu código...
    public String getContraseña() {
        return this.contraseña;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public boolean isSesionIniciada() {
        return this.sesionIniciada;
    }

    public void iniciarSesion() {
        // Lógica para iniciar sesión
        this.sesionIniciada = true;
        System.out.println("Sesión iniciada para el empleado " + this.nombre);
    }

    public void cerrarSesion() {
        // Lógica para cerrar sesión
        this.sesionIniciada = false;
        System.out.println("Sesión cerrada para el empleado " + this.nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }
// Getters y setters según sea necesario
}
