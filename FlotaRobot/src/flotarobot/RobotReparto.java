
package flotarobot;


public class RobotReparto extends Robot implements Diagnosticable, Ejecutable{
    
    private int capacidadCarga;
    
    public RobotReparto(String nroSerie, String fabricante, int nivelBateria,
            Prioridad prioridad, int capacidadCarga) {
        super(nroSerie, fabricante, nivelBateria, prioridad);
        this.capacidadCarga = capacidadCarga;

    }
    

    @Override
    public double calcularConsumoBateria() {
        return  (capacidadCarga * 3) + 4;
    }

    @Override
    public String toString() {
        return "RobotReparto{" + super.toString() + ", capacidadCarga=" + capacidadCarga + '}';
    }

    @Override
    public String generarDiagnostico() {
       return "Diagnostico de reparto " + getNroSerie() 
                + ": capacidad de " + capacidadCarga + " kg.";
    }

    @Override
    public void ejecutarServicio() {
        double consumo =calcularConsumoBateria();
        
        if(getNivelBateria() < consumo)  {
            throw new IllegalStateException(" Bateria insuficiente");
            }
            descontarBateria(consumo);
            System.out.println("Servicio de reparto " + getNroSerie() + 
                    " ejecutado. Bateria restante: " + getNivelBateria() + "%.");
        }
}


    
    

