/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
