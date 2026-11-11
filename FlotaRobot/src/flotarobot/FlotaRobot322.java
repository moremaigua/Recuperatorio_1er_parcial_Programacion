
package flotarobot;

import java.util.List;


public class FlotaRobot322 {

    
    public static void main(String[] args) {
        
    
        FlotaRobot flota = new FlotaRobot("TecnoAsistencia");
        
        try{
            flota.agregarRobot(new RobotLimpieza("RL-10", "Nova",  60,Prioridad.ALTA, 80));
            flota.agregarRobot(new RobotVigilancia("RV-20", "Orbis",  75, Prioridad.MEDIA, 3));  
            flota.agregarRobot(new RobotReparto("RR-30", "Nova",  40,Prioridad.BAJA, 5));
            flota.agregarRobot(new RobotReparto("RR-40", "Orbis", 15, Prioridad.ALTA, 4));
            flota.agregarRobot(new RobotVigilancia("RL-10", "Nova", 90,  Prioridad.BAJA,2));
        } catch (RobotDuplicadoException ex) {
            System.out.println("No se pudo agregar " + ex.getMessage());
        }
        
        
        System.out.println("Robots registrados:");
        mostrarRobots(flota.obtenerRobots());
        System.out.println("-------------------------------------------");
        //System.out.println("\nEjecución de servicios:");
        //ejecutarServicios(flota.obtenerRobots());
        System.out.println("\nDiagnósticos:");
        generarDiagnosticos(flota.obtenerRobots());
        System.out.println("----------------------------");
        System.out.println("\nRobots de prioridad ALTA:");
        mostrarRobots(flota.filtrarPorPrioridad(Prioridad.ALTA));
        System.out.println("-----------------------------------");
        System.out.println("\nRobots con consumo máximo de 18:");
        mostrarRobots(flota.obtenerRobotsConConsumoMaximo(18));
        System.out.println("---------------------------------");
        System.out.println("\nConsumos actuales:");
        mostrarConsumos(flota.obtenerRobots());
    }
    private static void mostrarRobots(List<Robot> robots) {
        for (Robot robot : robots) {
            System.out.println(robot);
        }
    }
    private static void ejecutarServicios(List<Robot> robots) {
        
        
    }
    private static void generarDiagnosticos(List<Robot> robots) {
          for(Robot robot : robots) {
              if(robot instanceof Diagnosticable){
                  Diagnosticable d = (Diagnosticable ) robot;
                  System.out.println(d.generarDiagnostico());
          } else{
                  System.out.println("El robot " + robot.getNroSerie() 
                          + " no genera diagnostico.");
              }
        }
    }
 private static void mostrarConsumos(List<Robot> robots) {
        for (Robot robot : robots) {
            System.out.println(robot.getNroSerie() + ": " + robot.calcularConsumoBateria() +
                    " puntos de bateria por operacion.");
            
        }
    }

    
}