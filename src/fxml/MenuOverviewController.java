/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import stillStandFMS.StillStandFMS;

/**
 *
 * @author QYL
 */
public class MenuOverviewController {
    private StillStandFMS stillStandFMS; 
    private Scene scene;
    public void setStillStandFMS(StillStandFMS stillStandFMS,Scene scene){
        this.stillStandFMS = stillStandFMS;
        this.scene = scene;
    }
    @FXML
    public void handleMenuAFXML() {
        try {
            // Localisation du fichier FXML.
            String adresse="FXML.fxml";
            // Localisation du fichier FXML.
            final URL url = getClass().getResource(adresse);
            // Création du loader.
            final FXMLLoader fxmlLoader = new FXMLLoader(url);        
            // Chargement du FXML.
            final Pane root = (Pane) fxmlLoader.load();            
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       //stillStandFMS.setStage(scene);      
    }
}
