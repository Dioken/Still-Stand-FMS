/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.EtatController.Etat;
import controller.MenuController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author bah
 */
public class StillStandFMS extends Application {
    
    private Stage primaryStage;    
    private BorderPane rootBorder;
    private FXMLLoader loaderCenter;
    Etat etat;
    Scene scene;
    @Override
    public void start(Stage primaryStage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.primaryStage = primaryStage;
        //this.primaryStage.setHeight(screenSize.getHeight());
        //this.primaryStage.setWidth(screenSize.getWidth());
        this.primaryStage.setFullScreen(true);        
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
            scene = new Scene(rootBorder);
            scene.getStylesheets().add("/view/StyleSheet1.css");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
          ex.printStackTrace();
        }
    }
    
    public void setStyleCss(int couleur){
        if(couleur==1){
            scene.getStylesheets().clear();
            scene.getStylesheets().add("/view/StyleSheet1.css");
        }else{           
            scene.getStylesheets().clear();
            scene.getStylesheets().add("/view/StyleSheet2.css");
        }        
    }
    
    private void showMenuView() {
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
        MenuController menuController = loaderCenter.getController();
        menuController.setStillStandFMS(rootBorder,this);

    }

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}