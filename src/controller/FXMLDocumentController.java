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

/**
 *
 * @author Esteban V
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Label tituloL;
    @FXML
    private TextArea areaTAD;
    @FXML
    private TextArea areaTA;
    
    @FXML
    private WebView WebView1;
    
    WebEngine webEngine;
    
    static Cola<Vehiculo>colaVehiculo;
    static LinkedList<Vehiculo> receptor2;
    static LinkedList<Vehiculo> receptor3;
    static LinkedList<Vehiculo> receptor4;
    
    
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
    public static LinkedList<Vehiculo> receptor1(){ //metodo que instancia el objeto tipo listener del receptor 1
        
       LinkedList<Vehiculo> receptor1 = new LinkedList<>();
       Cola<Vehiculo> duplicada= modelo.OperacionesCola.duplicarCola(colaVehiculo); 
       while(!duplicada.estaVacia()){
        Vehiculo obj= duplicada.desenColar();
        receptor1.add(obj);
       }
        //receptor1.add(desencolado);
        
        return receptor1;
       }
    
    @FXML
    private void encolarPersonas(ActionEvent event) {
        
        encolar siguiente= new encolar(); //objeto encolar tipo listener
        Timer encolamiento=new Timer(3000,siguiente); //encola cada 5 segundos
        encolamiento.start(); //empieza el temporizador
        
        int tiempo = elemento().getTiempoEspera();     
        boolean vacio= colaVehiculo.estaVacia(); //es verdadero cuando esta vacio
        
        if(vacio){
        desencolar desencolador = new desencolar(); //crea un nuevo receptor1 tipo listener
        Timer desencolando = new Timer(tiempo*1000,desencolador); //desencuela depentiendo del tiempo de espera
        desencolando.start();//empieza el temporizador//empieza el temporizador
        }
        receptor1();
    }
      public static Vehiculo elemento(){ // clase estatica que crea el nuevo elemento tipo vehiculo
          String nombre = nombre();
          String modelo= modelo();
          int tiempoEspera= numeroRandom();
          Vehiculo objV= new Vehiculo(nombre, modelo, tiempoEspera);
          return objV;
      }
         
      @FXML
    private void mostrarHTML(ActionEvent event) {
        areaTAD.setText(receptor1().toString());
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
        
        areaTA.appendText("El contenido de la cola es "+ colaVehiculo.toString()+"\n");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
       
        colaVehiculo=new Cola<>();
        
        
        //webEngine = WebView1.getEngine();
    }    
    
}
