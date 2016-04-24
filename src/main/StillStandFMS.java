/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.EtatController.Etat;
import controller.MenuOverviewController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author Bah
 */
public class StillStandFMS extends Application {
    
    private Stage primaryStage;    
    private BorderPane rootBorder;
    private FXMLLoader loaderCenter;
    Etat etat;
    @Override
    public void start(Stage primaryStage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.primaryStage = primaryStage;
        this.primaryStage.setHeight(screenSize.getHeight());
        this.primaryStage.setWidth(screenSize.getWidth());
        this.primaryStage.setTitle("MCDU"); 

        initRootLayout();
        showMenuView();   
        chargerMenuController(); 
    }
    
    /**
     * Initializes the root layout.
     */
    private void initRootLayout(){
        try {
            etat = Etat.Normal;
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StillStandFMS.class.getResource("/view/Root.fxml"));
            rootBorder = (BorderPane) loader.load();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootBorder);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
    }

    private void showMenuView(){
        try {
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/Menu.fxml"));
            AnchorPane personOverview = (AnchorPane) loaderCenter.load();
             // Set person overview into the center of root layout.
            rootBorder.setCenter(personOverview);
        } catch (IOException ex) {
          //System.err.println("Erreur au chargement: " + ex.getMessage()+ex.getCause());
          ex.printStackTrace();
        }
    }
    
     /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void chargerMenuController(){       
        MenuOverviewController menuController = loaderCenter.getController();
        menuController.setStillStandFMS(rootBorder);

    }

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}