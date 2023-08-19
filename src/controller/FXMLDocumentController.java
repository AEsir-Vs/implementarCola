/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import datos.Vehiculo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    
    Cola<Vehiculo>colaPersonas;
    
    @FXML
    private void encolarPersonas(ActionEvent event) {
        
        
          
        colaPersonas.encolar(new Vehiculo("nissan", "juan"+1, 1));
        colaPersonas.encolar(new Vehiculo("mazda", "juan"+2, 5));
        colaPersonas.encolar(new Vehiculo("chevrolet", "juan"+3, 4));
        

    }
    
    @FXML
    private void mostrarCola(ActionEvent event) {
        areaTA.appendText("El contenido de la cola es "+ colaPersonas.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        colaPersonas=new Cola<>();
    }    
    
}
