
package centrorescate322;

/**
 * Representa un mamifero registrado en el centro de rescate.
 * Hereda de Animal e implementa la interfaz Rehabilitable.
 * Su costo diario de mantenimiento depende de su peso.
 */
public class Mamifero extends Animal implements Rehabilitable{
    
    private final double peso;
    
     /**
     * Construye un mamifero con sus datos principales.
     *
     * @param codigo codigo identificatorio del mamifero
     * @param nombre nombre identificatorio del mamifero
     * @param estadoSalud estado de salud del mamifero
     * @param peso peso del mamifero en kilogramos
     * @throws IllegalArgumentException si algun dato es invalido
     */
    public Mamifero(String codigo, String nombre, 
            EstadoSalud estadoSalud, double peso) {
        super(codigo, nombre, estadoSalud);
        validarPeso(peso);
        this.peso = peso;
    }
    
    private void validarPeso(double peso) {
        if(peso <= 0) {
            throw new IllegalArgumentException("Peso invalido");
        }
    }

    public double getPeso() {
        return peso;
    }

    /**
     * Calcula el costo diario de mantenimiento del mamifero.
     *
     * @return costo diario multiplicando el peso por 10
     */
    @Override
    public double calcularCostoDiario() {
        return peso * 10;
    }

     /**
     * Realiza la accion de rehabilitacion del mamifero.
     *
     * @return mensaje que identifica al mamifero en rehabilitacion
     */
    @Override
    public String rehabilitar() {
        return "El Mamifero " + getNombre() + " esta en rehabilitacion.";
    }

    @Override
    public String toString() {
        return super.toString() + "peso=" + peso + '}';
    }
    
    
    
    
    
}
