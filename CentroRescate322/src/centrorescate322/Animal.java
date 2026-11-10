
package centrorescate322;

import java.util.Objects;

/**
 * animal registrado en el centro de rescate.
 * Contiene su codigo, nombre y estado de salud.
 * clase abstracta de la que heredan los distintos
 * tipos de animales.
 */
public abstract class Animal {
    
    private final String codigo;
    private final String nombre;
    private final EstadoSalud estadoSalud;
    
    
    /**
     * Construye un animal con sus datos principales.
     *
     * @param codigo codigo identificatorio del animal
     * @param nombre nombre identificatorio del animal
     * @param estadoSalud estado de salud del animal
     * @throws IllegalArgumentException si algun dato es invalido
     */
    public Animal (String codigo, String nombre, EstadoSalud estadoSalud) {
        validarParametros(codigo, nombre, estadoSalud);
        this.codigo = codigo;
        this.nombre = nombre;
        this.estadoSalud = estadoSalud;
        
    }
    
    private void validarCodigo(String codigo) {
        if(codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("Codigo invalido");
        }
           
    }
    
    private void validarNombre( String nombre) {
       if(nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre invalido");
        } 
        
    }
    
    private void validarEstadoSalud( EstadoSalud estadoSalud) {
        if(estadoSalud == null) {
            throw new IllegalArgumentException("Estado de Salud invalido");
        }
    }
    
    private void validarParametros(String codigo, String nombre, EstadoSalud estadoSalud) {
        validarCodigo(codigo);
        validarNombre(nombre);
        validarEstadoSalud(estadoSalud);
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }
    
    
    /**
     * Calcula el costo diario de mantenimiento del animal.
     * Cada tipo de animal implementa su propio calculo.
     *
     * @return costo diario de mantenimiento
     */
    public abstract double calcularCostoDiario();
    
    /**
     * Genera un codigo hash a partir del codigo y nombre del animal.
     *
     * @return codigo hash del animal
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
    
    /**
     * Compara dos animales por su codigo y nombre.
     *
     * @param o objeto con el que se compara
     * @return true si tienen el mismo codigo y nombre,
     *         false en caso contrario
     */
    @Override
    public boolean equals(Object o) { 
        if(o == null){
            return false;
        }
        if(o == this) {
            return true;
        }
        if(o instanceof Animal otroAnimal){
            
            return codigo.equals(otroAnimal.codigo) 
                    && nombre.equals(otroAnimal.nombre);
        }
        return false;
        
    }
    
    /**
     * Devuelve una representacion en texto del animal.
     *
     * @return datos principales del animal
     */
    @Override
    public String toString(){
        return getClass().getSimpleName() +"{" + "Codigo=" + codigo
                + ", Nombre=" + nombre
                + ", Estado de Salud=" + estadoSalud + ",";
    }
    
    
    
}
