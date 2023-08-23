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
    
    static int tiempoEspera= (int)(Math.random()*6+1);
    
   /* public static class encolar implements ActionListener{ //metodo listener para encolar
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
           
        }   
    }*/
    
    
    /*public class mostrar implements ActionListener{ //metodo listener para mostrar el contenido de la cola
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
          areaTA.appendText("El contenido de la cola es "+ colaVehiculo.toString()+"\n");
        }   
    }*/
    
    public void disponibilidad(){  //metodo no funcional  
        boolean ocupado=false;
        boolean vacio= colaVehiculo.estaVacia();
        if(!ocupado && vacio){
            ocupado=true;
        }
        
       }
    
    @FXML
    private void encolarPersonas(ActionEvent event) {
 
        
       /*numeroRandom tiempoEspera= new numeroRandom();
       Timer segundosEspera= new Timer(1000, tiempoEspera);
       segundosEspera.start();*/
       
       /*nombreRandom nombre= new nombreRandom();
       Timer miNombre=new Timer(1000, nombre);
       miNombre.start();*/
        
        //colaVehiculo.encolar(new Vehiculo("nissan", "joan",tiempoEspera));
        
        encolar siguiente= new encolar(); //objeto encolar tipo listener
        Timer encolamiento=new Timer(2000,siguiente); //encola cada 5 segundos
        encolamiento.start(); //empieza el temporizador
        
     
        /*mostrar Mostrar=new mostrar();//objeto mostrar tipo listener
        Timer mostrando =new Timer(1000,Mostrar);//muestra cada sg el contenido de la cola 
        mostrando.start(); //empieza el temporizador*/
        
 //    colaVehiculo.encolar(new Vehiculo("nissan", "joan",tiempoEspera));
        
        boolean ocupado=false;
        boolean vacio= colaVehiculo.estaVacia();
        if(!ocupado && !vacio){
            ocupado=true;
                      
            if(ocupado){
             String mensaje="El receptor 1 esta ocupado";
             receptor1 nombre= new receptor1();//objeto tipo listener 
             Timer desencolar= new Timer (tiempoEspera*1000,nombre);//desencola la cantidad de segundos que le indica el tiempo en espera
             desencolar.start();  //empieza el temporizador
             areaTA.appendText(mensaje);
            }
            
       } /*else {
           
            String mensaje="El receptor 2 esta ocupado";
             receptor2 nombre= new receptor2();
             Timer desencolar2= new Timer (tiempoEspera*1000,nombre);
             desencolar2.start();
             areaTA.appendText(String.valueOf(mensaje));
            
        }*/
    }
         
       public static class encolar implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            int tiempoEspera= (int)(Math.random()*6+1);
            colaVehiculo.encolar(new Vehiculo("nissan", "joan",tiempoEspera));
        }
       }
       
       public static class receptor1 implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 1

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
           Vehiculo receptor = colaVehiculo.receptor1();
        } 
       }
       
       public static class receptor2 implements ActionListener{ //metodo que instancia el objeto tipo listener del receptor 2

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {  
           Vehiculo receptor = colaVehiculo.receptor2();
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
