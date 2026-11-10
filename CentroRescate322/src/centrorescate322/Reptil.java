
package centrorescate322;

/**
 * Representa un reptil registrado en el centro de rescate.
 * Hereda de Animal e implementa la interfaz Liberable.
 * Su costo diario de mantenimiento depende de su longitud.
 */
public class Reptil extends Animal implements Liberable{
    
    private final double longitud;
    
    /**
     * Construye un reptil con sus datos principales.
     *
     * @param codigo codigo identificatorio del reptil
     * @param nombre nombre identificatorio del reptil
     * @param estadoSalud estado de salud del reptil
     * @param longitud longitud del reptil en centimetros
     * @throws IllegalArgumentException si algun dato es invalido
     */
    public Reptil(String codigo, String nombre, 
            EstadoSalud estadoSalud, double longitud) {
        super(codigo, nombre, estadoSalud);
        validarLongitud(longitud);
        this.longitud = longitud;
    }
    
    private void validarLongitud(double longitud) {
        if(longitud <= 0) {
            throw new IllegalArgumentException("Longitud invalido");
        }
    }

    public double getLongitud() {
        return longitud;
    }

    /**
     * Calcula el costo diario de mantenimiento del reptil.
     * @return costo diario sumando 15 a la longitud
     */
    @Override
    public double calcularCostoDiario() {
        return longitud + 15;
    }

    /**
     * Realiza la accion de liberacion del reptil.
     * @return mensaje que identifica al reptil en liberacion
     */
    @Override
    public String liberar() {
        return "El Reptil " + getNombre() + " esta en liberacion.";
    }

    @Override
    public String toString() {
        return super.toString() + "longitud=" + longitud + '}';
    }

    
    
}
