
package centrorescate322;

import java.util.List;


public class CentroRescate322 {

    
    public static void main(String[] args) {
        
        CentroRescate centro = new CentroRescate("FaunaSur");
        
        
        
        try{
            centro.agregarAnimal(new Ave("AV-10", "Luna", EstadoSalud.ESTABLE, 80));
            centro.agregarAnimal(new Mamifero("MA-20", "Puma", EstadoSalud.EN_RECUPERACION,12));
            centro.agregarAnimal(new Reptil("RE-30", "Sol", EstadoSalud.ESTABLE, 65));
            centro.agregarAnimal(new Ave("AV-40", "Nube", EstadoSalud.CRITICO, 50));
        
            centro.agregarAnimal(new Reptil("AV-10", "Luna", EstadoSalud.CRITICO, 90));
        
        }
        catch (AnimalDuplicadoException ex) {
            System.out.println(ex.getMessage());
            System.out.println("--------------------------");
        }
        
        
        System.out.println("Animales registrados:");
        mostrarAnimales(centro.obtenerAnimales());
        System.out.println("--------------------------------------");
        System.out.println("Rehabilitaciones:");
        mostrarRehabilitaciones(centro.obtenerAnimales());
        System.out.println("--------------------------------------");
        System.out.println("Liberaciones:");
        mostrarLiberaciones(centro.obtenerAnimales());
        System.out.println("--------------------------------------");
        System.out.println("Costo diario de cada animal:");
        mostrarCostos(centro.obtenerAnimales());
        System.out.println("--------------------------------------");
        System.out.println("Animales ESTABLES:");
        mostrarAnimales(centro.filtrarPorEstado(EstadoSalud.ESTABLE));
        System.out.println("--------------------------------------");
        System.out.println("Animales con costo diario hasta 100:");
        mostrarAnimales(centro.obtenerAnimalesConCostoMaximo(100));

        
   
    }
    
    private static void mostrarAnimales(List<Animal> animales) {
        for(Animal animal : animales){
            System.out.println(animal);
        }
    }
    
    private static void mostrarRehabilitaciones(List<Animal> animales) {
        for(Animal animal : animales){
            if(animal instanceof Rehabilitable){
                Rehabilitable rehabilitable = (Rehabilitable) animal;
                System.out.println(rehabilitable.rehabilitar());
                
            }
        }
    }
    
    private static void mostrarLiberaciones(List<Animal> animales) { 
        for(Animal animal : animales){
            if(animal instanceof Liberable){
                Liberable liberable = (Liberable) animal;
                System.out.println(liberable.liberar());
                
            }
        }
    }
    
    private static void mostrarCostos(List<Animal> animales) {
        for(Animal animal : animales) {
            System.out.println(animal.getNombre() + ": $" + animal.calcularCostoDiario());
        }
    }
    
}
