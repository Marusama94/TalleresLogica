// Cliente.java
package model;

public class Cliente {

    private String nombre;
    private String celular;
    private String usuario;
    private String contraseña;
    private boolean sesionIniciada;

    public Cliente(String nombre, String celular, String usuario, String contraseña) {
        this.nombre = nombre;
        this.celular = celular;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.sesionIniciada = false; // Al crear el cliente, la sesión no está iniciada
    }
    public String getNombre() {
        return nombre;
    }
    public void cerrarSesion() {
        this.sesionIniciada = true;
        System.out.println("Sesión cerrada para el cliente " + this.nombre);
    }
    public void iniciarSesion() {
        this.sesionIniciada = true;
        System.out.println("Sesión iniciada para el cliente " + this.nombre);
    }

    // Getters para acceder a los datos

    public String getCelular() {
        return this.celular;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getUsuario() {
        return this.usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public boolean isSesionIniciada() {
        return this.sesionIniciada;
    }
}

