
package centrorescate322;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un centro de rescate de animales.
 * Permite registrar animales, consultar los animales
 * almacenados y filtrarlos segun su estado de salud
 * o su costo diario de mantenimiento.
 */
public class CentroRescate {
    
    private String nombre;
    private List<Animal> animales;

    /**
     * Construye un centro de rescate con un nombre
     * e inicializa la lista de animales.
     *
     * @param nombre nombre del centro de rescate
     * @throws IllegalArgumentException si el nombre es invalido
     */
    public CentroRescate(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
        this.animales = new ArrayList<>();
        
        
    }

    public String getNombre() {
        return nombre;
    }

    private void validarNombre( String nombre) {
        if(nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre invalido");
        }
    }
    
     /**
     * Agrega un animal al centro .
     * Verifica que el animal no sea nulo ni este
     * registrado previamente.
     *
     * @param animal animal que se desea agregar
     * @throws IllegalArgumentException si el animal es nulo
     * @throws AnimalDuplicadoException si el animal ya existe
     */
    public void agregarAnimal(Animal animal) throws AnimalDuplicadoException {
        if(animal == null) {
            throw new IllegalArgumentException(" Animal Invalido");
        }
        if(animales.contains(animal)) {
            throw new AnimalDuplicadoException("Animal Duplicado");
        }
        animales.add(animal);
    }
    
    /**
     * Devuelve una nueva lista respetando el orden de carga de todos
     * los animales registrados.
     *
     * @return lista de animales registrados
     */
    public ArrayList<Animal> obtenerAnimales() {
        return new ArrayList<>(animales);
    }
    
    /**
     * Filtra los animales segun su estado de salud.
     *
     * @param estadoSalud estado de salud que se desea buscar
     * @return lista de animales que tienen el estado indicado
     * @throws IllegalArgumentException si el estado es nulo
     */
    public ArrayList<Animal> filtrarPorEstado(EstadoSalud estadoSalud) {
       
        if(estadoSalud == null) {
            throw new IllegalArgumentException (" Estado de Salud invalido");
        }
        
        ArrayList<Animal> filtrados = new ArrayList<>();
        
        for(Animal animal : animales) {
            if(animal.getEstadoSalud() == estadoSalud) {
                filtrados.add(animal);  
            }
        }
        return filtrados;
    }
   
     /**
     * Obtiene los animales cuyo costo diario de mantenimiento
     * sea menor o igual al valor maximo indicado.
     *
     * @param maximo costo diario maximo permitido
     * @return lista de animales que cumplen con el costo maximo
     * @throws IllegalArgumentException si el maximo es invalido
     */
    public ArrayList<Animal> obtenerAnimalesConCostoMaximo(double maximo) {
        
        if(maximo <= 0 ) {
            throw new IllegalArgumentException("Maximo invalido");   
        }
        
        ArrayList<Animal> animalesConCostoMaximo = new ArrayList<>();
        
        for(Animal animal : animales) {
            if(animal.calcularCostoDiario() <= maximo ) {
                animalesConCostoMaximo.add(animal);
            }
        }
        return animalesConCostoMaximo;
    }
        
    
    
    
    
}
