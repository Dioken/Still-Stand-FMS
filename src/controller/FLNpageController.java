/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import main.StillStandFMS;

/**
 *
 * @author QYL
 */
public class FLNpageController {
    private BorderPane rootBorder;
    
    public void setFLNpageController(BorderPane rootBorder){
        this.rootBorder = rootBorder;
    }
    @FXML
    public void handleEntererListe(){
        try {                    
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/Liste.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            rootBorder.setCenter(FXMLViewCenter);

            ListCheminController controller = loaderCenter.getController();
            controller.setList();

            
            //A mettre dans un autre controlleur ce qui est en commentaire
            /* 
            FXMLLoader loaderCenter = new FXMLLoader();
            loaderCenter.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            AnchorPane FXMLViewCenter = (AnchorPane) loaderCenter.load();
            SplitPane splitPane = (SplitPane) FXMLViewCenter.getChildren().get(0);
            
            FXMLLoader loaderDown = new FXMLLoader();
            loaderDown.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            AnchorPane clavier = (AnchorPane) loaderDown.load();
                    
            
            splitPane.getItems().set(1, clavier);
            rootBorder.setCenter(FXMLViewCenter);*/
            
            //FXMLLoader loaderDown = new FXMLLoader();
            //loaderDown.setLocation(StillStandFMS.class.getResource("/view/Clavier.fxml"));
            //rootBorder.getChildren().get(0).setClip(FXMLLoader);
            //FXMLViewCenter.getChildren().add(loaderDown);
        } catch (IOException ex) {
            Logger.getLogger(MenuOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
