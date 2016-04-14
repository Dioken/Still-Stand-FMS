/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stillStandFMS;

import fxml.MenuOverviewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author QYL
 */
public class StillStandFMS extends Application {
    private Stage primaryStage;
    private Scene scene;
    private FXMLLoader loaderCenter;
    private FXMLLoader loaderMain;    
    private BorderPane rootBorder;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MCDU");
        
        initRootLayout();
        showMenuView();
        
        chargerMenuController();        
    }
 
    public void initRootLayout(){
        try {
            loaderMain=new FXMLLoader();
            loaderMain.setLocation(StillStandFMS.class.getResource("../fxml/Root.fxml"));
            rootBorder = (BorderPane)loaderMain.load();
            
            scene = new Scene(rootBorder);   
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
          System.err.println("Erreur au chargement: " + ex);
        }
    }

    public void showMenuView(){
        try {
            loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("../fxml/Menu.fxml"));
            AnchorPane menuView = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(menuView);
        } catch (IOException ex) {
          System.err.println("Erreur au chargement: " + ex);
        }
    }

    public void chargerMenuController(){       
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