package services;

public class Servicio {
    private String nombre;
    private String descripcion;
    private double precio;

    public Servicio(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    // Constructor, atributos y otros métodos aquí...

    public String getNombre() {
        return this.nombre;
    }


    public void comprar() {
        // Lógica para realizar la compra del servicio
        System.out.println("Compra exitosa: " + this.nombre + " - " + this.descripcion);
        // Aquí podrías integrar la funcionalidad para generar una solicitud interna en la base de datos
        // por ejemplo, agregar esta compra a la base de datos de solicitudes internas.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
// Getters y setters según sea necesario
}
