/*
 *  @author esteban.vargas@uao.edu.co, Esteban Vargas Sanchez, Codigo 2221675
 *  @author emmanuel.carrera@uao.edu.co, Emmanuel Carrera Cardona, Codigo 2221577
 *  @author carlos_andres.garzon@uao.edu.co, Carlos Andres Garzon Guerrero, Codigo 2220968
 *  @author joan.salcedo@uao.edu.co, Joan Sebastian Salcedo Obando, Codigo 2220769
 *  @date 31 /Agosto/2023
 *  @version 1.0
 */
package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Esteban V
 *
⠀*            (\ __ /)
 *             (UwU )
 *          ＿ノ ヽ ノ＼＿ 
 *        /　`/ ⌒Ｙ⌒ Ｙ　 \
 *       ( 　(三ヽ人　 /　　|
 *        |　ﾉ⌒＼ ￣￣ヽ　 ノ
 *        ヽ＿＿＿＞､＿＿／
 *           ｜( 王 ﾉ〈 
 *           /ﾐ`ー―彡\ 
 *         / ╰      ╯  \
 */
public class ImplementarCola extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
