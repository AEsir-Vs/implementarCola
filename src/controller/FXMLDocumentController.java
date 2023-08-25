/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datos.Vehiculo;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.Timer;
import modelo.Cola;

/**
 *
 * @author Esteban V
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label nombrePL;
    
    @FXML
    private Label correoPL;
    
    @FXML
    private Label numeroPL;
    
    @FXML
    private Label tituloL;
    
    @FXML
    private TextField nombreTXT;
    
    @FXML
    private TextField correoTXT;
    
    @FXML
    private TextField numeroTXT;
    
    @FXML
    private TextArea areaTA;
    
    static Cola<Vehiculo>colaVehiculo;
    
  
    
  
    /*public void disponibilidad(){  //metodo no funcional  
        boolean ocupado=false;
        boolean vacio= colaVehiculo.estaVacia();
        if(!ocupado && vacio){
            ocupado=true;
        }
   
       }*/
    public static int numeroRandom(){
        int tiempoEspera= (int)(Math.random()*6+1);
        return tiempoEspera;
    }
    public static String nombre(){
        String nombre= "Juan";
        int numero= (int)(Math.random()*10+1);
        nombre+=numero;
        return nombre;
    }
    public static String modelo(){
        String modelo= "Nissan";
         int numero= (int)(Math.random()*10+1);
        modelo+=numero;
        return modelo;
    }
    
    public static class receptor1 implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
               colaVehiculo.receptor1();
        } 
       }
    public static class receptor2 implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
               colaVehiculo.receptor2();
        } 
       }
    
    @FXML
    private void encolarPersonas(ActionEvent event) {
        
        encolar siguiente= new encolar(); //objeto encolar tipo listener
        Timer encolamiento=new Timer(2000,siguiente); //encola cada 5 segundos
        encolamiento.start(); //empieza el temporizador
        
             
        
       
        boolean r1Ocupado=false;
        boolean vacio= colaVehiculo.estaVacia(); //es verdadero cuando esta vacio
        if(!r1Ocupado && vacio){
            r1Ocupado=true;
                      
            if(r1Ocupado){
             String mensaje="El receptor 1 esta ocupado";
             areaTA.appendText(mensaje);
             int tiempo = elemento().getTiempoEspera();
             receptor1 desencolar = new receptor1(); //crea un nuevo receptor1 tipo listener
             Timer desencolando = new Timer(tiempo*1000,desencolar); //desencuela depentiendo del tiempo de espera
             desencolando.start();//empieza el temporizador//empieza el temporizador  
            }
    
        }
    }
      public static Vehiculo elemento(){ // clase estatica que crea el nuevo elemento tipo vehiculo
          String nombre = nombre();
          String modelo= modelo();
          Vehiculo objV= new Vehiculo(nombre, modelo, numeroRandom());
          return objV;
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
    }    
    
}
