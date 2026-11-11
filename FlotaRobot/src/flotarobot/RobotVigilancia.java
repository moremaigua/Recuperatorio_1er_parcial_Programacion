
package flotarobot;


public class RobotVigilancia extends Robot implements Diagnosticable{
    
    private int cantidadCamaras;
    
    public RobotVigilancia(String nroSerie, String fabricante, int nivelBateria,
            Prioridad prioridad, int cantidadCamaras) {
        super(nroSerie, fabricante, nivelBateria, prioridad);
        this.cantidadCamaras = cantidadCamaras;
    }

    @Override
    public double calcularConsumoBateria() {
       return (cantidadCamaras * 4) + 6;
    }

    @Override
    public String generarDiagnostico() {
        return "Diagnostico de vigilancia " + getNroSerie() 
                + cantidadCamaras + " camaras operativas.";
    }

    @Override
    public String toString() {
        return "RobotVigilancia{" +  super.toString()+ ", cantidadCamaras=" + cantidadCamaras + '}';
    }

    
    
    
    
    
}
