/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stillStandFMS;

import fxml.MenuOverviewController;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author QYL
 */
public class StillStandFMS extends Application {
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MCDU");
        
        try {
            // Localisation du fichier FXML.
            String adresse="../fxml/Menu.fxml";
            // Localisation du fichier FXML.
            final URL url = getClass().getResource(adresse);
            // Création du loader.
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            // Chargement du FXML.
            final AnchorPane root = (AnchorPane) fxmlLoader.load();
            // Création de la scène.
            final Scene scene = new Scene(root, 600, 400);            
            
            MenuOverviewController menuController = fxmlLoader.getController();
            menuController.setStillStandFMS(this,scene);
            
            
            primaryStage.setScene(scene);
        } catch (IOException ex) {
          System.err.println("Erreur au chargement: " + ex);
        }
        primaryStage.show();
    }
    public void setTitre(String titre){
        this.primaryStage.setTitle(titre);
    }
    
    public void setStage(Scene scene){
        primaryStage.setScene(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}