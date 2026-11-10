
package centrorescate322;

/**
 * Representa un ave del centro de rescate.
 * Hereda de Animal e implementa las interfaces
 * Rehabilitable y Liberable.
 */
public class Ave extends Animal implements Rehabilitable, Liberable{
    
    private final double envergaduraAlar;
    
    /**
     * Construye un ave con sus datos principales.
     *
     * @param codigo codigo identificatorio del ave
     * @param nombre nombre identificatorio del ave
     * @param estadoSalud estado de salud del ave
     * @param envergaduraAlar medida de las alas en centimetros
     * @throws IllegalArgumentException si algun dato es invalido
     */
    public Ave(String codigo, String nombre, 
            EstadoSalud estadoSalud, double envergaduraAlar) {
        super(codigo, nombre, estadoSalud);
        validarEnvergaduraAlar(envergaduraAlar);
        this.envergaduraAlar = envergaduraAlar;
    }

    public double getEnvergaduraAlar() {
        return envergaduraAlar;
    }
    
    private void validarEnvergaduraAlar(double envergaduraAlar) {
        if(envergaduraAlar <= 0) {
            throw new IllegalArgumentException("Envergadura Alar invalida");
        }
    }

    /**
     * Calcula el costo diario de mantenimiento del ave.
     *
     * @return costo diario multiplicando la envergadura alar por 2
     */
    @Override
    public double calcularCostoDiario() {
        return  envergaduraAlar *2; 
    }

     /**
     * Realiza la accion de rehabilitacion del ave.
     *
     * @return mensaje que identifica al ave en rehabilitacion
     */
    @Override
    public String rehabilitar() {
        return "El Ave " + getNombre() + " esta en rehabilitacion.";
    }

    /**
     * Realiza la accion de liberacion del ave.
     *
     * @return mensaje que identifica al ave en liberacion
     */
    @Override
    public String liberar() {
        return "El Ave " + getNombre() + " esta en liberacion.";
    }

    @Override
    public String toString() {
        return super.toString() + " EnvergaduraAlar=" + envergaduraAlar + '}';
    }
    
}
