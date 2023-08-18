/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementarcola;

import datos.Persona;
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
    
    Cola<Persona>colaPersonas;
    
    @FXML
    private void encolarPersonas(ActionEvent event) {
        
        String nombreP=nombreTXT.getText();
        String correoP=correoTXT.getText();
        String numeroP=numeroTXT.getText();
        
        colaPersonas.encolar(new Persona(nombreP, correoP, numeroP));

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
