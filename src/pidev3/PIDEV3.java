/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev3;

import Views.BackendController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author aymen
 */
public class PIDEV3 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
     
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
   Parent root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
        Scene scene = new Scene(root);
      
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    
}
}