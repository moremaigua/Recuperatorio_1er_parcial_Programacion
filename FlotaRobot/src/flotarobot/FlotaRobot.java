
package flotarobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FlotaRobot {
    
    private String nombre;
    private List<Robot> robots;

    public FlotaRobot(String nombre) {
        this.nombre = nombre;
        this.robots = new ArrayList<>();
        
    }
    
    public void agregarRobot(Robot robot) throws RobotDuplicadoException {
         if (robot == null) {
             throw new IllegalArgumentException("Robot invalido");  
    }
        if (robots.contains(robot)) {
            throw new RobotDuplicadoException(" Robot Duplicado");
        }
        
        robots.add(robot);
       
    
    }
    
    public List<Robot> obtenerRobots() {
        return new ArrayList<>(robots);
    }
    
    public List<Robot> filtrarPorPrioridad(Prioridad prioridad) {
        List<Robot> filtrados = new ArrayList<>();
        
        for (Robot robot : robots) {
            if(robot.getPrioridad() == prioridad) {
                filtrados.add(robot);
            }
        }
        return filtrados;
    }
    
    public List<Robot> obtenerRobotsConConsumoMaximo(double maximo) {
        List<Robot> robotsConConsumoMaximo = new ArrayList<>();
        
        for (Robot robot : robots) {
            if(robot.calcularConsumoBateria() <= maximo) {
                robotsConConsumoMaximo.add(robot);
            }
        }
        return robotsConConsumoMaximo;
    }
    
    
}
