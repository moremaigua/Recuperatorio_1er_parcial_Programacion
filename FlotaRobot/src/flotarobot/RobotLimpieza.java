
package flotarobot;


public class RobotLimpieza extends Robot implements Ejecutable{
    
    private int superficie;
    
    public RobotLimpieza(String nroSerie, String fabricante, int nivelBateria,
            Prioridad prioridad, int superficie) {
        super(nroSerie, fabricante, nivelBateria, prioridad);
        this.superficie = superficie;
    
        
}

    @Override
    public double calcularConsumoBateria() {
        return (superficie / 10) + 5;
    }


    

    @Override
    public String toString() {
        return "RobotLimpieza{" + super.toString() + ", superficie=" + superficie + '}';
    }

    @Override
    public void ejecutarServicio() {
        double consumo =calcularConsumoBateria();
        
        if(getNivelBateria() < consumo)  {
            throw new IllegalStateException(" Bateria insuficiente");
            }
            descontarBateria(consumo);
            System.out.println("Servicio de limpieza " + getNroSerie() + 
                    " ejecutado. Bateria restante: " + getNivelBateria() + "%.");
        }

}
    
    

