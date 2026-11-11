
package flotarobot;

import java.util.Objects;


public abstract  class Robot {
    
    private String nroSerie;
    private String fabricante;
    private int nivelBateria;
    private Prioridad prioridad ;

    public Robot(String nroSerie, String fabricante, int nivelBateria, Prioridad prioridad) {
        this.nroSerie = nroSerie;
        this.fabricante = fabricante;
        this.nivelBateria = nivelBateria;
        this.prioridad = prioridad;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getNivelBateria() {
        return nivelBateria;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
    
    public abstract double calcularConsumoBateria();
    
    protected void descontarBateria(double consumo) {
        if (consumo < 0 || nivelBateria < consumo) {
            throw new IllegalStateException(" Bateria insuficiente");
            
        }
        nivelBateria -= consumo;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        
        if ( obj instanceof Robot otroRobot) {
            return nroSerie.equals(otroRobot.nroSerie) &&
                    fabricante.equals(otroRobot.fabricante);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nroSerie);
        hash = 97 * hash + Objects.hashCode(this.fabricante);
        return hash;
    }

    
    
    @Override
    public String toString() {
        return "Robot{" + "nroSerie=" + nroSerie 
                + ", fabricante=" + fabricante 
                + ", nivelBateria=" + nivelBateria 
                + ", prioridad=" + prioridad + ", ";
    }
    
    
    
    
    
    
    
}
