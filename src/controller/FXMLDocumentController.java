/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datos.Vehiculo;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.Timer;
import modelo.Cola;
import Modelo.Receptor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Esteban V
 */
public class FXMLDocumentController implements Initializable {
    
    static WebEngine web;
    LinkedList<Receptor> receptores = new LinkedList<>();
    static Cola<Vehiculo> colaVehiculo;
    public int tiempoTotal;
    
    @FXML
    private Label tituloL;

    @FXML
    private TextArea areaTA;
    
    @FXML
    private WebView WebView1;
    
    
    //temportizador para mostrar en el text Area
     mostrar nuevo= new mostrar(); //objeto encolar tipo listener
     Timer mostrar=new Timer(1000,nuevo);
     
    //temporizador para encolar
    static encolar siguiente= new encolar(); //objeto encolar tipo listener
    static Timer encolamiento=new Timer(1000,siguiente);
    
    //temporizador para desencolar 
    static desencolar desencolador = new desencolar(); //crea un nuevo receptor1 tipo listener
    static int tiempo = elemento().getTiempoEspera();  
    static Timer desencolando = new Timer(tiempo*1000,desencolador);
    //temporizador para mostrar en el html
    mostrarHtml tabla= new mostrarHtml();
    Timer nuevaTabla= new Timer(1000,tabla);
    
    //crea los 4 receptores
    private void llenarListaReceptores() {
        for (int i = 0; i < 4; i++) {
            receptores.add(new Receptor());
        }
    }
    private void revisarReceptoresLibres() {
        for (Receptor obj : receptores) {
            if (obj.isLibre() && !colaVehiculo.estaVacia()) {
                Vehiculo v = colaVehiculo.desenColar();
                obj.setLibre(false);
                obj.setTiempoOcupado(v.getTiempoEspera());
                obj.setContadorVehiculos(obj.getContadorVehiculos() + 1);

                areaTA.appendText("Receptor" + obj + "ocupado, " +"durante :"+ obj.getTiempoOcupado()+"\n");
                obj.setTiempoTotal(v.getTiempoEspera() + obj.getTiempoTotal());
               
            } else {
                if (obj.getTiempoOcupado() > 0) {
                    obj.setTiempoOcupado(obj.getTiempoOcupado() - 1);

                }
                if (obj.getTiempoOcupado() == 0) {
                    obj.setLibre(true);
                    areaTA.appendText("Receptor #:  " + obj + ". libre"+"\n");
                }
            }
        }
    }
    
    public static int numeroRandom(){
        int tiempoEspera= (int)(Math.random()*6+1);
        return tiempoEspera;
    }
    public static String nombre(){
        LinkedList<String> nombres = new LinkedList<>();
        nombres.add("Juan");
        nombres.add("Esteban");
        nombres.add("Emmanuel");
        nombres.add("Carlos");
        nombres.add("Santiago");
        nombres.add("Luciana");
        nombres.add("Sofia");
        nombres.add("Catalina");
        nombres.add("Marcela");
        
         Random random = new Random();
        int indiceAleatorio = random.nextInt(nombres.size());
        
        return nombres.get(indiceAleatorio);
    }
    public static String modelo(){
        
        LinkedList<String> modelos= new LinkedList<>();
        modelos.add("Nissan");
        modelos.add("Mazda");
        modelos.add("Chevrolet");
        modelos.add("Suzuki");
        modelos.add("Foton");
        modelos.add("Honda");
        
        
        Random random = new Random();
        int indiceAleatorio = random.nextInt(modelos.size());
        
        return modelos.get(indiceAleatorio);
    }
   
    public static class desencolar implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
           colaVehiculo.desenColar();
        } 
        
       }
    
    
    @FXML
    private void empezar(ActionEvent event) {
        
        encolamiento.start(); //empieza el temporizador para encolar
        mostrar.start(); //empieza el temporizador para mostrar
        
        boolean vacio= colaVehiculo.estaVacia(); //es verdadero cuando esta vacio
        if(!vacio){
               
                desencolando.start();//empieza el temporizador//empieza el temporizador 
          }
    }
      public static Vehiculo elemento(){ // clase es tatica que crea el nuevo elemento tipo vehiculo
          String nombre = nombre();
          String modelo= modelo();
          int tiempoEspera= numeroRandom();
          Vehiculo objV= new Vehiculo(nombre, modelo, tiempoEspera);
          return objV;
      }
    
    @FXML
    private void Detener(ActionEvent event) {
        encolamiento.stop();
        desencolando.stop(); 
        mostrar.stop();
        nuevaTabla.stop();
        areaTA.appendText(mostrarInforme());
        almacenarEnArchivoTexto();
    }
    
    @FXML
    private void mostrarHTML(ActionEvent event) {
      /* String html = datos.Tools.convertirColaAHtml(colaVehiculo);
       web.loadContent(html); */
       String html = datos.Tools.convertirColaAHtml(colaVehiculo);
       web.loadContent(html); 
     //  areaTAD.setText(receptor1().toString()+"\n"+receptor1().size()+" cliente(s) despachados");
        
    }
     public String mostrarInforme() {
        String informe = "";
        String inf1 = calcularCantidadVehiculosAtendidosPorCadaReceptor();
        String inf2 = calcularTiempoCadaReceptor();
        String inf3 = calcularPromedio();
        informe = inf1 + inf2 + inf3;
        return informe;
    }
     
    public String calcularCantidadVehiculosAtendidosPorCadaReceptor() {
        String reporte = "";
        int i = 0;
        for (Receptor elem : receptores) {
            i++;
            reporte = reporte + "La Cantidad de carros atendidos por el receptor " + i + " fueron de : " + elem.getContadorVehiculos() + "\n";
        }
        return reporte;
    }
    public String calcularPromedio() {
        String reporte = "";
        int tiempoTotalReceptores = 0;
        for (Receptor elem : receptores) {
            tiempoTotalReceptores += elem.getTiempoTotal();
        }
        tiempoTotalReceptores = tiempoTotalReceptores / 4;
        reporte = "El tiempo promedio es de : " + tiempoTotalReceptores + "\n";
        return reporte;
    }

    public String calcularTiempoCadaReceptor() {
        String reporte = "";
        for (int i = 0; i < receptores.size(); i++) {
            reporte = reporte + "El receptor #" + i + " atendio un total de: " + receptores.get(i).getTiempoTotal() + "s" + "\n";
        }
        return reporte;
    }
    
     public void almacenarEnArchivoTexto() {
        try {
            String nombreArchivo = "datosReceptores.txt";
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo)));
            String linea = mostrarInforme();
            salida.println(linea);
            salida.close();
        } catch (IOException e) {
            System.out.println("Sucedio un error en almacenarEnArchivoTexto: " + e);
        }
    }
    
    
    
     public class mostrarHtml implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
           String html = datos.Tools.convertirColaAHtml(colaVehiculo);
           web.loadContent(html); 
        }   
       }
    public class mostrar implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          revisarReceptoresLibres();
          
          
        }   
       }
    
    public static class encolar implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1 
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
          Vehiculo objV= elemento();
          colaVehiculo.encolar(objV); //encuela el objeto tipo vehiculo 
        }   
       }
          
        /*colaPersonas.encolar(new Vehiculo("mazda", "juan"+2, 5));
        colaPersonas.encolar(new Vehiculo("chevrolet", "juan"+3, 4));*/       
    
    
    @FXML
    private void mostrarCola(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarListaReceptores();
        colaVehiculo=new Cola<>();
        web = WebView1.getEngine();        
    }    
    
}
