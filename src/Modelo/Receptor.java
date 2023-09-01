/*
 *  @author esteban.vargas@uao.edu.co, Esteban Vargas Sanchez, Codigo 2221675
 *  @author emmanuel.carrera@uao.edu.co, Emmanuel Carrera Cardona, Codigo 2221577
 *  @author carlos_andres.garzon@uao.edu.co, Carlos Andres Garzon Guerrero, Codigo 2220968
 *  @author joan.salcedo@uao.edu.co, Joan Sebastian Salcedo Obando, Codigo 2220769
 *  @date 31 /Agosto/2023
 *  @version 1.0
 */
package Modelo;

/**
 *
 * @author lucel
 */
public class Receptor {
    private boolean Libre = true;
    private int contadorVehiculos = 0;
    private int tiempoTotal = 0;
    
    private int tiempoOcupado;

    public int getTiempoOcupado() {
        return tiempoOcupado;
    }

    public void setTiempoOcupado(int tiempoOcupado) {
        this.tiempoOcupado = tiempoOcupado;
    }
    
    public Receptor() {
    }

    public boolean isLibre() {
        return Libre;
    }

    public void setLibre(boolean Libre) {
        this.Libre = Libre;
    }

    public int getContadorVehiculos() {
        return contadorVehiculos;
    }

    public void setContadorVehiculos(int contadorVehiculos) {
        this.contadorVehiculos = contadorVehiculos;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }
    
    
}
